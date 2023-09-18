package gui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import nimgame.TwoComputers;
import nimgame.Resenje_AlfaBeta;
import nimgame.Resenje_Takmicar;
import nimgame.SimpleMinimaxPlayer;

public class Nim {

	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	private Node state;
	private Node nodeHelp = new Node();
	private Nim nim;
	private List<Integer> lista;

	private int expandedNodes;
	private boolean koIgra;

	public Nim(Node state) {
		this.state = state;
	}

	public Nim() {
		Integer[] what;
		if (Resenje_Takmicar.playerTakmicar == 1) {
			what = Arrays.stream(Resenje_Takmicar.stanje).boxed().toArray(Integer[]::new);
		} else if (Resenje_AlfaBeta.playerAlfaBeta == 1) {
			what = Arrays.stream(Resenje_AlfaBeta.stanje).boxed().toArray(Integer[]::new);
		} else {
			what = Arrays.stream(SimpleMinimaxPlayer.stanje).boxed().toArray(Integer[]::new);
		}
		Node node = new Node(what);
		nim = new Nim(node);
		JOptionPane.showMessageDialog(null, "Computer igra !");

	}

	public Nim(int a) {
		Integer[] what = Arrays.stream(TwoComputers.stanje).boxed().toArray(Integer[]::new);
		Node node = new Node(what);
		nim = new Nim(node);
		JOptionPane.showMessageDialog(null, "Potez u toku !");

	}

	public Node novoStanje() {
		expandedNodes = 0;
		return nim.startGame();
	}

	private static List<Node> generateChildNodes(Node node) {
        if (node.isEmpty()) {
            return Collections.emptyList();
        }

        List<Node> nodes = new ArrayList<>();
        List<Integer> piles = node.getPiles();

        for (int i = 0; i < piles.size(); i++) {
            List<Integer> temp = node.getPiles();
            while (temp.get(i) > 0) {
                temp.set(i, temp.get(i) - 1); 
                Node child = new Node(node, temp); //zatim kreiram novi node element i njega dodam u listu koja ce da mi bude lista dece
                nodes.add(child);
            }
        }
        return nodes;
    }

	private static int minimaxAlfa(Node node, int depth, boolean maximizingPlayer, int min, int max) {
		if (depth == 0 || node.isEmpty()) {
			return (maximizingPlayer ? 1 : -1) * heuristicEvaluation(node);
		}

		if (maximizingPlayer) { 
			int v = Integer.MIN_VALUE; 
			for (Node child : generateChildNodes(node)) { 
				int vI = minimaxAlfa(child, depth - 1, false, v, max); 
				if (vI > v) {
					v = vI;
				}
				if (v > max) {
					return max;
				}
				child.setHeuristicValue(vI);
				node.setHeuristicValue(v);
			}
			return v;
		} else {
			int v = Integer.MAX_VALUE;
			for (Node child : generateChildNodes(node)) {
				int vI = minimaxAlfa(child, depth - 1, true, min, v); 
				if (vI < v) {
					v = vI;
				}
				if (v < min) {
					return min;
				}
				node.setHeuristicValue(v);
				child.setHeuristicValue(vI);
			}
			return v;
		}
	}

	private static int minimax(Node node, int depth, boolean maximizingPlayer) { 
	
		if (depth == 0 || node.isEmpty()) { 
			return (maximizingPlayer ? 1 : -1) * heuristicEvaluation(node);
		}

		if (maximizingPlayer) { 
			int bestValue = Integer.MIN_VALUE; 
			for (Node child : generateChildNodes(node)) { 
				int value = minimax(child, depth - 1, false); 
				if (value > bestValue) {
					bestValue = value;
				}
				child.setHeuristicValue(value);
				node.setHeuristicValue(bestValue);
			}
			return bestValue;
		} else {
			int bestValue = Integer.MAX_VALUE;
			for (Node child : generateChildNodes(node)) {
				int value = minimax(child, depth - 1, true); 
				if (value < bestValue) {
					bestValue = value;
				}
				node.setHeuristicValue(bestValue);
				child.setHeuristicValue(value);
			}
			return bestValue;
		}
	}

	private static int heuristicEvaluation(Node node) {
		return nimSum(node) != 0 ? 1 : -1;
	}

	private static int nimSum(Node node) {
		int xor = 0;
		for (Integer pile : node.getPiles()) {
			xor ^= pile;
		}
		return xor;
	}

	private static List<Integer> readPiles() {
		boolean finished = false;
		List<Integer> result = new ArrayList<>();
		while (!finished) {
			try {
				System.out.println("Enter piles:");
				String[] pilesText = reader.readLine().split(", ");
				result.addAll(Arrays.stream(pilesText).map(Integer::parseInt).collect(Collectors.toList()));
				finished = true;
			} catch (Exception e) {
				System.out.println("Wrong input");
			}
		}
		return result;
	}

	public Node startGame() {

		if (Resenje_AlfaBeta.playerAlfaBeta == 1) {
			return alfaComputerMove();
		}
		if (Resenje_Takmicar.playerTakmicar == 1) {
			return takmicarComputerMove();
		}

		//////////////////////////////////////////
		// deo koji se odnosi na dva racunara ///
		//////////////////////////////////////////

		if ((IzborIgre.tipIgre == 3)) {

			if (TwoComputers.vrstaIgraca == 1) {
				if (Tezina2Racunara.tipRacunara == 1 && Tezina2Racunara.tipRacunara2 == 1) {
					koIgra = (TwoComputers.currentPlayer);
					return comupterMove(); // zbog ovog mi treba vrstaIgraca
											// promenljiva
				}
			}

			////////////////////////////////////////////////////////////////////////////

			if (TwoComputers.vrstaIgraca == 1) {
				if (Tezina2Racunara.tipRacunara == 1 && Tezina2Racunara.tipRacunara2 == 2) {
					koIgra = true;
					return comupterMove(); // zbog ovog mi treba vrstaIgraca
											// promenljiva
				}
			}

			if (TwoComputers.vrstaIgraca == 2) {
				if (Tezina2Racunara.tipRacunara == 1 && Tezina2Racunara.tipRacunara2 == 2) {
					koIgra = false;
					return alfaComputerMove(); // zbog ovog mi treba vrstaIgraca
												// promenljiva
				}
			}

			//////////////////////////////////////////////////////////////////////////////

			if (TwoComputers.vrstaIgraca == 1) {
				if (Tezina2Racunara.tipRacunara == 1 && Tezina2Racunara.tipRacunara2 == 3) {
					koIgra = true;
					return comupterMove(); // zbog ovog mi treba vrstaIgraca
											// promenljiva
				}
			}

			if (TwoComputers.vrstaIgraca == 3) {
				if (Tezina2Racunara.tipRacunara == 1 && Tezina2Racunara.tipRacunara2 == 3) {
					koIgra = false;
					return takmicarComputerMove(); // zbog ovog mi treba
													// vrstaIgraca promenljiva
				}
			}

			//////////////////////////////////////////////////////////////////////////////

			if (TwoComputers.vrstaIgraca == 2) {
				if (Tezina2Racunara.tipRacunara == 2 && Tezina2Racunara.tipRacunara2 == 2) {
					koIgra = TwoComputers.currentPlayer;
					return alfaComputerMove(); // zbog ovog mi treba vrstaIgraca
												// promenljiva
				}
			}

			///////////////////////////////////////////////////////////////////////

			if (TwoComputers.vrstaIgraca == 2) {
				if (Tezina2Racunara.tipRacunara == 2 && Tezina2Racunara.tipRacunara2 == 3) {
					koIgra = true;
					return alfaComputerMove(); // zbog ovog mi treba vrstaIgraca
												// promenljiva
				}
			}

			if (TwoComputers.vrstaIgraca == 3) {
				if (Tezina2Racunara.tipRacunara == 2 && Tezina2Racunara.tipRacunara2 == 3) {
					koIgra = false;
					return takmicarComputerMove(); // zbog ovog mi treba
													// vrstaIgraca promenljiva
				}
			}

			/////////////////////////////////////////////////////////////////////////////

			if (TwoComputers.vrstaIgraca == 1) {
				if (Tezina2Racunara.tipRacunara == 2 && Tezina2Racunara.tipRacunara2 == 1) {
					koIgra = true;
					return comupterMove(); // zbog ovog mi treba vrstaIgraca
											// promenljiva
				}
			}

			if (TwoComputers.vrstaIgraca == 2) {
				if (Tezina2Racunara.tipRacunara == 2 && Tezina2Racunara.tipRacunara2 == 1) {
					koIgra = false;
					return alfaComputerMove(); // zbog ovog mi treba vrstaIgraca
												// promenljiva
				}
			}

			////////////////////////////////////////////////////////////////////////////

			if (TwoComputers.vrstaIgraca == 1) {
				if (Tezina2Racunara.tipRacunara == 3 && Tezina2Racunara.tipRacunara2 == 1) {
					koIgra = true;
					return comupterMove(); // zbog ovog mi treba vrstaIgraca
											// promenljiva
				}
			}

			if (TwoComputers.vrstaIgraca == 3) {
				if (Tezina2Racunara.tipRacunara == 3 && Tezina2Racunara.tipRacunara2 == 1) {
					koIgra = false;
					return takmicarComputerMove(); // zbog ovog mi treba
													// vrstaIgraca promenljiva
				}
			}

			////////////////////////////////////////////////////////////////////////////
			if (TwoComputers.vrstaIgraca == 2) {
				if (Tezina2Racunara.tipRacunara == 3 && Tezina2Racunara.tipRacunara2 == 2) {
					koIgra = true;
					return alfaComputerMove(); // zbog ovog mi treba vrstaIgraca
												// promenljiva
				}
			}

			if (TwoComputers.vrstaIgraca == 3) {
				if (Tezina2Racunara.tipRacunara == 3 && Tezina2Racunara.tipRacunara2 == 2) {
					koIgra = false;
					return takmicarComputerMove(); // zbog ovog mi treba
													// vrstaIgraca promenljiva
				}
			}

			////////////////////////////////////////////////////////////////////////////////////

			if (TwoComputers.vrstaIgraca == 3) {
				if (Tezina2Racunara.tipRacunara == 3 && Tezina2Racunara.tipRacunara2 == 3) {
					koIgra = TwoComputers.currentPlayer;
					return takmicarComputerMove(); // zbog ovog mi treba
													// vrstaIgraca promenljiva
				}
			}

			////////////////////////////////////////////////////////////////////////////////

		}

		// if((IzborIgre.tipIgre==3) && (TwoComputers.currentPlayer==false)){
		// koIgra=false;
		// if(TwoComputers.vrstaIgraca==1 )return comupterMove();
		// if(TwoComputers.vrstaIgraca==2 )return alfaComputerMove();
		// if(TwoComputers.vrstaIgraca==3 )return takmicarComputerMove();
		//
		// }

		return comupterMove();

	}

	private void userMove() {
		System.out.println("----User move----");
		System.out.println("Current state: " + state);
		state = move();
		System.out.println("After move: " + state);
	}



	private Node takmicarComputerMove() {
		System.out.println("----Computer move----");
		System.out.println("Current state: " + state);

		int pom = 0;
		if (IzborIgre.tipIgre == 2) {

			pom = minimaxAlfa(state, Tezina1Racunar.tezina, false, Integer.MIN_VALUE, Integer.MIN_VALUE);

		
		}

		else if (IzborIgre.tipIgre == 3) {
			pom = minimaxAlfa(state, Tezina2Racunara.tezina, koIgra, Integer.MIN_VALUE, Integer.MIN_VALUE);
		}

		int minimax = pom;

	
		Optional<Node> perfectMove = state.getChildList().stream().filter(n -> n.getHeuristicValue() == minimax)
				.findFirst();
		state = perfectMove.orElse(state.getChildList().get(0));
		nodeHelp = state;
		System.out.println("After move: " + state);
		return nodeHelp;
	}

	private Node alfaComputerMove() {
		System.out.println("----Computer move----");
		System.out.println("Current state: " + state);

		int pom = 0;
		if (IzborIgre.tipIgre == 2) {

			pom = minimaxAlfa(state, Tezina1Racunar.tezina, false, Integer.MIN_VALUE, Integer.MIN_VALUE);

			
		}

		else if (IzborIgre.tipIgre == 3) {
			pom = minimaxAlfa(state, Tezina2Racunara.tezina, koIgra, Integer.MIN_VALUE, Integer.MIN_VALUE);
		}

		int minimax = pom;

		
		Optional<Node> perfectMove = state.getChildList().stream().filter(n -> n.getHeuristicValue() == minimax)
				.findAny();
		state = perfectMove.orElse(state.getChildList().get(0));
		nodeHelp = state;
		System.out.println("After move: " + state);
		return nodeHelp;
	}

	

	private Node comupterMove() {
		System.out.println("----Computer move----");
		System.out.println("Current state: " + state);

		int pom = 0;
		if ((IzborIgre.tipIgre == 1) || (IzborIgre.tipIgre == 2)) {
			pom = minimax(state, Tezina1Racunar.tezina, true);
		} else if (IzborIgre.tipIgre == 3) {
			pom = minimax(state, Tezina2Racunara.tezina, koIgra);
		}
		int minimax = pom;



		
		Optional<Node> perfectMove = state.getChildList().stream().filter(n -> n.getHeuristicValue() == minimax)
				.findAny();
		state = perfectMove.orElse(state.getChildList().get(0));
		nodeHelp = state;
		System.out.println("After move: " + state);
		return nodeHelp;
	}

	private Node move() {
		while (true) {
			int pile = readNum("Choose pile:") - 1;
			List<Integer> piles = state.getPiles();
			if (pile <= 0 || piles.size() < pile) { 
				System.out.println("Wrong pile number");
				continue;
			}

			int amount = readNum("Amount pile:");
			if (amount <= 0 || piles.get(pile) == 0 || piles.get(pile) < amount) {
				System.out.println("Wrong amount");
				continue;
			}

			piles.set(pile, piles.get(pile) - amount);
			return new Node(state, piles);
		}
	}

	private int readNum(String text) { 
		boolean finished = false;
		int result = 0;
		while (!finished) {
			try {
				System.out.println(text);
				result = Integer.parseInt(reader.readLine());
				finished = true;
			} catch (Exception e) {
				System.out.println("Wrong input");
			}
		}
		return result;
	}
}