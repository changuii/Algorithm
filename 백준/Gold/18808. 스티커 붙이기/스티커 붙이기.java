import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] notebook = new int[N][M];

        List<int[][]> stickers = new ArrayList<>();

        for(int k = 0; k<K; k++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[n][m];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<m; j++){
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            stickers.add(sticker);
        }

        for(int[][] sticker : stickers){
            attach(notebook, sticker);
        }

        System.out.println(answer);
    }

    public static void attach(int[][] notebook, int[][] sticker){
        int type = 0;
        boolean isAttach = false;
        while (type < 4 && !isAttach) {
            for(int i=0; i<notebook.length && !isAttach; i++){
                for(int j=0; j<notebook[0].length && !isAttach; j++){
                    if(isAttachable(notebook, sticker, i, j, type)){
                        attachSticker(notebook, sticker, i, j, type);
                        isAttach = true;
                    }
                }
            }
            type++;
        }
    }

    public static boolean isAttachable(int[][] notebook, int[][] sticker, int x, int y, int type){
        int X = x;
        int Y = y;
        if(type == 0){
            for(int i=0; i<sticker.length; i++){
                for(int j=0; j<sticker[0].length; j++){
                    if(j == 0) Y = y;
                    if(!(X >= 0 && X < notebook.length && Y >=0 && Y < notebook[0].length)) return false;
                    if(notebook[X][Y] != 0 && sticker[i][j] == 1){
                        return false;
                    }
                    Y++;
                }
                X++;
            }
        } else if (type == 1){
            for(int j=0; j<sticker[0].length; j++){
                for(int i=sticker.length-1; i>=0; i--){
                    if(i == sticker.length-1) Y = y;
                    if(!(X >= 0 && X < notebook.length && Y >=0 && Y < notebook[0].length)) return false;
                    if(notebook[X][Y] != 0 && sticker[i][j] == 1){
                        return false;
                    }
                    Y++;
                }
                X++;
            }
        } else if (type == 2){
            for(int i=sticker.length-1; i>=0; i--){
                for(int j=sticker[0].length-1; j>=0; j--){
                    if(j == sticker[0].length-1) Y = y;
                    if(!(X >= 0 && X < notebook.length && Y >=0 && Y < notebook[0].length)) return false;
                    if(notebook[X][Y] != 0 && sticker[i][j] == 1){
                        return false;
                    }
                    Y++;
                }
                X++;
            }
        } else if (type == 3){
            for(int j=sticker[0].length-1; j>=0; j--){
                for(int i=0; i<sticker.length; i++){
                    if(i == 0) Y = y;
                    if(!(X >= 0 && X < notebook.length && Y >=0 && Y < notebook[0].length)) return false;
                    if(notebook[X][Y] != 0 && sticker[i][j] == 1){
                        return false;
                    }
                    Y++;
                }
                X++;
            }
        }
        return true;
    }

    public static void attachSticker(int[][] notebook, int[][] sticker, int x, int y, int type){
        int X = x;
        int Y = y;
        if(type == 0){
            for(int i=0; i<sticker.length; i++){
                for(int j=0; j<sticker[0].length; j++){
                    if(j == 0) Y = y;
                    if(sticker[i][j] == 1){
                        notebook[X][Y] = sticker[i][j];
                        answer++;
                    }
                    Y++;
                }
                X++;
            }
        } else if (type == 1){
            for(int j=0; j<sticker[0].length; j++){
                for(int i=sticker.length-1; i>=0; i--){
                    if(i == sticker.length-1) Y = y;
                    if(sticker[i][j] == 1){
                        notebook[X][Y] = sticker[i][j];
                        answer++;
                    }
                    Y++;
                }
                X++;
            }
        } else if (type == 2){
            for(int i=sticker.length-1; i>=0; i--){
                for(int j=sticker[0].length-1; j>=0; j--){
                    if(j == sticker[0].length-1) Y = y;
                    if(sticker[i][j] == 1){
                        notebook[X][Y] = sticker[i][j];
                        answer++;
                    }
                    Y++;
                }
                X++;
            }
        } else if (type == 3){
            for(int j=sticker[0].length-1; j>=0; j--){
                for(int i=0; i<sticker.length; i++){
                    if(i == 0) Y = y;
                    if(sticker[i][j] == 1){
                        notebook[X][Y] = sticker[i][j];
                        answer++;
                    }
                    Y++;
                }
                X++;
            }
        }
    }
}