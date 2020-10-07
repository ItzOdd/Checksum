package cegepst;

public class Encoder {

    private int[][] binaryGrid;
    private int[] parityArray;
    private int gridHeight;
    private final int GRID_WIDTH = 9;
    private int rowNumber = 0;

    // TODO : placer les public en haut

    public Encoder(String entry) {
        this.gridHeight = getGridHeight(entry);
        initialiseGrid();
        convertToBinary(entry);
    }

    private void convertToBinary(String entry) {
        int strLength = entry.length();
        String binaryString;
        for (int i = 0; i < strLength; i++) {
            binaryString = toBinary(entry.charAt(i));
            putInGrid(binaryString, i);
        }
    }

    private void putInGrid(String binaryString, int index) {
        parityArray = new int[9];
        for (int i = 0; i < binaryString.length(); i++) {
            parityArray[i] = binaryString.charAt(i);
            binaryGrid[rowNumber][i] = binaryString.charAt(i);
        }
        binaryGrid[rowNumber][9] = calculateParityBit(parityArray);
        rowNumber++;
    }

    public int calculateParityBit(int[] parityArray) {
        int sum = 0;
        for (int j : parityArray) {
            sum += j;
        }
        if (sum % 2 == 0) {
            return 0;
        }
        return 1;
    }

    public String toBinary(char currentChar) {
        // TODO : 7 - longeurResult = zero a mettre (for loop)
        String result = Integer.toBinaryString(currentChar);
        if (result.length() <= 7 && result.charAt(0) == '1') {
            return "0" + result;
        }
        return result;
    }

    private void initialiseGrid() {
        this.binaryGrid = new int[this.gridHeight][this.GRID_WIDTH];
    }

    public int getGridHeight(String entry) {
        int strLength = entry.length();
        if (strLength <= 8) {
            return strLength;
        }
        return (strLength / 8) + strLength;
    }
}