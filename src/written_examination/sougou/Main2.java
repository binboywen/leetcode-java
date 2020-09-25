package written_examination.sougou;

public class Main2 {
    public void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        int times = dC - tC;
        int tmp = 0;
        for (int i = 0; i != times; i++) {
            tmp = m[tR][tC + i];
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[dR][dC - i] = m[tR + i][dC];
            m[tR + i][dC] = tmp;
        }
    }
    public String rotatePassword (String[] s1, String[] s2) {
        // write code here
        if(s1 == null || s2 == null){
            return null;
        }
        int n = (int)Math.sqrt(s1.length);
        int [][] array = new int[n][n];
        String [][] strings = new String[n][n];
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                array[i][j] = Integer.valueOf(s1[index]);
                strings[i][j] = s2[index++];
            }
        }
        int rotaNum = 4;
        StringBuffer sb = new StringBuffer();
        while(rotaNum-- > 0){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(array[i][j] == 0){
                        sb.append(strings[i][j]);
                    }
                }
            }
            rotate(array);
        }
        return sb.toString();

    }


}
