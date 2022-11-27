public class SeaBoard {

    private String[][] field = new String[][]{
            {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
    };

    /*
    public String[][] getField() {
        return field;
    }
    */
    public void getField() {
        for (int y = 0; y < 10; y++) {
            System.out.println();
            for (int x = 0; x < 10; x++) {
                System.out.print(field[y][x]);
            }
        }
        System.out.println();
    }

    public void shoot(int line, int column, String issue) {
        if (line > 9 || line < 0 || column > 9 || column < 0 || issue != "m" && issue != "h" && issue != "d") {
            System.out.println("\nError");
        } else {
            if (issue == "m") {
                field[line][column] = "#";
            } else if (issue == "h") {
                field[line][column] = "x";
            } else if (issue == "d") {
                field[line][column] = "x";
                destroy(line, column);
            }
        }
    }

    public String chek(int line, int column) {
        return field[column][line];
    }

    public void destroy(int line, int column) {
        int[][] array = new int[10][2];
        int i = 0;

        for (int x = column; x <= 9; x++) {
            if (field[line][x] == "x") {
                array[i][0] = line;
                array[i][1] = x;
                System.out.println(array[i][0]);
                System.out.println(array[i][1]);
                i++;
            }
        }

        for (int x = column - 1; x >= 0; x--) {
            if (field[line][x] == "x") {
                array[i][0] = line;
                array[i][1] = x;
                System.out.println(array[i][0]);
                System.out.println(array[i][1]);
                i++;
            }
        }

        for (int y = line - 1; y >= 0; y--) {
            if (field[y][column] == "x") {
                array[i][0] = y;
                array[i][1] = column;
                System.out.println(array[i][0]);
                System.out.println(array[i][1]);
                i++;
            }
        }

        for (int y = line + 1; y <= 9; y++) {
            if (field[y][column] == "x") {
                array[i][0] = y;
                array[i][1] = column;
                System.out.println(array[i][0]);
                System.out.println(array[i][1]);
                i++;
            }
        }

        for (int y = 0; y < i; y++) {
            for (int x = 0; x < 3; x++) {
                if (array[y][0]-1 < 0 || array[y][1] - 1 + x < 0 || array[y][1] - 1 + x > 9) {
                    continue;
                } else {
                    if (field[array[y][0] - 1][array[y][1] - 1 + x] == "x") {
                        continue;
                    } else {
                        field[array[y][0] - 1][array[y][1] - 1 + x] = "#";
                    }
                }
            }
            for (int x = 0; x < 3; x++) {
                if (array[y][0]+1 > 9 || array[y][1] - 1 + x < 0 || array[y][1] - 1 + x > 9) {
                    continue;
                } else {
                    if (field[array[y][0] + 1][array[y][1] - 1 + x] == "x") {
                        continue;
                    } else {
                        field[array[y][0] + 1][array[y][1] - 1 + x] = "#";
                    }
                }
            }
            for (int x = 0; x < 3; x++) {
                if (array[y][1] - 1 + x < 0 || array[y][1] - 1 + x > 9) {
                    continue;
                } else {
                    if (field[array[y][0]][array[y][1] - 1 + x] == "x") {
                        continue;
                    } else {
                        field[array[y][0]][array[y][1] - 1 + x] = "#";
                    }
                }
            }


        }

    }

}
