package climbing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class Driver {
	public static void main(String[] args) {
		try( BufferedReader reader = new BufferedReader( new FileReader( new File("input\\input00.txt") ) ) ) {
			reader.readLine();
			int[] leaderBoard = Stream.of(reader.readLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
			reader.readLine();
			int[] aliceScore = Stream.of(reader.readLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
			int[] positions = getRanks(leaderBoard, aliceScore);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int[] getRanks(int[] leaderBoard, int[] aliceScore) {
		// TODO Auto-generated method stub
		return null;
	}
}
