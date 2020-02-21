package climbing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Driver {
	public static void main(String[] args) throws IOException {
		Path inputFolder = Paths.get(".\\input");	
		Files.list(inputFolder)
		.forEach(e -> drive(e.toFile(), new File( e.toString().replace("input", "output"))));
	}
	private static void drive(File inputFile, File outputFile) {
		int[] positions = new int[1];
		try( BufferedReader reader = new BufferedReader( new FileReader( inputFile ) ) ) {
			reader.readLine();
			int[] leaderBoard = Stream.of(reader.readLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
			reader.readLine();
			int[] aliceScore = Stream.of(reader.readLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
			positions = getRanks(leaderBoard, aliceScore);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try( PrintWriter writer = new PrintWriter( new FileWriter( outputFile ) ) ) {
			for(int i = 0; i < positions.length; i++) {
				writer.println(positions[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
	private static int[] getRanks(int[] leaderBoard, int[] aliceScore) {
		int[] ranks = new int[aliceScore.length];
		for (int i = 0; i < aliceScore.length; i++) {
			int currentScore = 0;
			int currentRank = 1; 
			for(int j = 0; j < leaderBoard.length; j++) {
				if(leaderBoard[j] != currentScore) {
					currentScore = leaderBoard[j];
					currentRank++;
				}
				ranks[i] = currentRank;
				if (aliceScore[i] > leaderBoard[j]) {
					currentScore = 0;
					currentRank = 1; 
					for(int k = 0; k < leaderBoard.length; k++) {
						currentScore = leaderBoard[k];
						if(currentScore <= aliceScore[i]) {
							ranks[i] = currentRank;
							break;
						} else {
							if(currentScore != leaderBoard[k + 1]) {
								currentRank++;
							}
						}
					}
				}
			}
		}
 		return ranks;
	}
}
