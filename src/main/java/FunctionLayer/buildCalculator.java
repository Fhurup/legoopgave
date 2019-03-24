/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author frederik
 */
public class buildCalculator {
    
    
    
    public int[] builder (int length, int width, int height){
        int x4 = length / 4;
        int x2 = 0;
        int x1 = 0;
        
         switch (length % 4) {
            case 0:
                break;
            case 1:
                x1++;
                break;
            case 2:
                width += 2;
                break;
            case 3:
                width += 2;
                x1++;
        }
            if (length >= 4) {
            width = width - 4;
        }
        x4 = width / 4 + x4;
        switch (width % 4) {
            case 0:
                break;
            case 1:
                x1++;
                break;
            case 2:
                x2++;
                break;
            case 3:
                x2++;
                x1++;
        }
        x4 = x4 * height * 2;
        x2 = x2 * height * 2;
        x1 = x1 * height * 2;
        int[] ret = {x4, x2, x1};
        return ret;
       
    }
}
