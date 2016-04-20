/**
 * @author      Timothy Kiyui (4316886@students.swinburne.edu.my)
 * @version     0.1
 * @since       19.04.2016
 */

package com.Kiyivinski;

import java.util.Scanner;

public class CLIInput extends Input{
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
