/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm_misa;

import java.util.Scanner;

/**
 *
 * @author tongd
 */
public class ACM_Misa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int s = sc.nextInt();
        sc.nextLine();
        char[][] church = new char[r][s];
        for(int i = 0; i < r; i++) {
            String line = sc.nextLine();
            for(int l = 0; l < s; l++) {
                church[i][l] = line.charAt(l);
            }
        }
        int bestM = 0;
        int mirko = 0;
        for(int i = 0; i < r; i++) {
            for(int l = 0; l < s; l++) {
                if(church[i][l] == '.') {
                    if(i > 0 && church[i - 1][l] == 'o') mirko++;
                    if(i > 0 && l > 0 && church[i - 1][l - 1] == 'o') mirko++;
                    if(l > 0 && church[i][l-1] == 'o') mirko++;
                    if(i < (r - 1) && church[i+1][l] == 'o') mirko++;
                    if(l < (s - 1) && church[i][l+1] == 'o') mirko++;
                    if(i < (r - 1) && l < (s - 1) && church[i+1][l+1] == 'o') mirko++;
                    if(i > 0 && l < s - 1 && church[i-1][l+1] == 'o') mirko++;
                    if(i < r - 1 && l > 0 && church[i+1][l-1] == 'o') mirko++;
                    
                    if(mirko > bestM) bestM = mirko;
                    mirko = 0;
                }
            }
        }
        int shakes = 0;
        for(int i = 0; i < r; i++) {
            for(int l = 0; l < s; l++) {
                if(church[i][l] == 'o') {
                    if(i < (r - 1) && church[i+1][l] == 'o') shakes++;
                    if(l < (s - 1) && church[i][l+1] == 'o') shakes++;
                    if(i < (r - 1) && l < (s - 1) && church[i+1][l+1] == 'o') shakes++;
                    if(i > 0 && l < s - 1 && church[i-1][l+1] == 'o') shakes++;
                }
            }
        }
        System.out.println(shakes+bestM);
    }
    
}
