
// 150120013 Irem Aydýn
// 150120009 Hatice Yavuzsan
// 150121013 Irem Kýranmezar


import java.io.*;
import java.util.Scanner;

public class _150120013_150120009_150121013{

    // This method returns whether the string data is identifier or not.
    public static boolean isIdentifier(String str) {
        boolean valid = false;

        String allowedChars = "!*\":<=>?abcdefghijklmnopqrstuvyzwx";
        String allowedChars2 = "+-.0123456789abcdefghijklmnopqrstuvyzwx";
        if (!isBoo(str) && !isKeyword(str)) {
            if (str.length() == 1) {
                if (str.charAt(0) == '.' || str.charAt(0) == '+' || str.charAt(0) == '-') {
                    valid = true;
                }

                else if (allowedChars.indexOf(str.charAt(0)) == -1) {
                    return false;
                } else
                    valid = true;

            } else if(str.length()>1){
                if (str.charAt(0) == '.' || str.charAt(0) == '+' || str.charAt(0) == '-') {
                    for (int i = 1; i < str.length(); i++) {
                        if (allowedChars2.indexOf(str.charAt(i)) == -1) {
                            return false;
                        } else
                            valid = true;
                    }
                } else {
                    if (allowedChars.indexOf(str.charAt(0)) == -1) {
                        return false;
                    } else {
                        for (int i = 1; i < str.length(); i++) {
                            if (allowedChars2.indexOf(str.charAt(i)) == -1) {
                                return false;
                            } else
                                valid = true;
                        }
                    }

                }

            }
        }

        return valid;
    }


    // This method returns whether the string data is boolean or not.
    public static boolean isBoo(String str) {
        boolean valid = false;

        if (str.equals("true") || str.equals("false")) {
            valid = true;
        } else
            return false;

        return valid;
    }

    public static void error(int r, String c){
        System.out.println("LEXICAL ERROR [" + r +":"+ (c.indexOf(0)) + "]: Invalid token " + "'" + c + "'" );
    }

    // This method returns whether the string data is number or not.
    public static boolean isNumber(String str) {
        boolean valid = false;
        boolean dot = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                if (dot) {
                    dot = false;
                    break;
                }
                dot = true;
            }
        }

        boolean e = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'e' || str.charAt(i) == 'E') {
                if (e) {
                    e = false;
                    break;
                }
                e = true;
            }
        }
        if (str.length() >= 2) {
            if (str.charAt(0) == '0' && str.charAt(1) == 'x') {
                String allowedChars = "0123456789abcdefABCDEF";
                for (int i = 2; i < str.length(); i++) {
                    if (allowedChars.indexOf(str.charAt(i)) == -1) {
                        return false;
                    } else
                        valid = true;
                }
            } else if (str.charAt(0) == '0' && str.charAt(1) == 'b') {
                for (int i = 2; i < str.length(); i++) {
                    if (str.charAt(i) == '1' || str.charAt(i) == '0') {
                        valid = true;
                    } else
                        return false;
                }
            }

            else if (str.charAt(0) == '-' || str.charAt(0) == '+') {
                String allowedChars = "0123456789";
                if (str.contains(".") && dot) {
                    String[] array = str.split("\\.");

                    if ((str.contains("e")) && e) {
                        if (str.charAt(1) == '.') {
                            String[] afterDot = array[1].split("e");

                            for (int i = 0; i < afterDot[0].length(); i++) {
                                if (allowedChars.indexOf(afterDot[0].charAt(i)) == -1) {
                                    return false;
                                } else
                                    valid = true;
                            }

                            if (afterDot[1].charAt(0) == '-' || afterDot[1].charAt(0) == '+') {
                                for (int i = 1; i < afterDot[1].length(); i++) {
                                    if (allowedChars.indexOf(afterDot[1].charAt(i)) == -1) {
                                        return false;
                                    } else
                                        valid = true;
                                }

                            } else if (Character.isDigit(str.charAt(0))) {
                                for (int i = 1; i < afterDot[1].length(); i++) {
                                    if (allowedChars.indexOf(afterDot[1].charAt(i)) == -1) {
                                        return false;
                                    } else
                                        valid = true;
                                }
                            }

                        } else {

                            for (int i = 1; i < array[0].length(); i++) {
                                if (allowedChars.indexOf(array[0].charAt(i)) == -1) {
                                    return false;
                                } else
                                    valid = true;
                            }
                            String[] afterDot = array[1].split("e");
                            for (int i = 0; i < afterDot[0].length(); i++) {
                                if (allowedChars.indexOf(afterDot[0].charAt(i)) == -1) {
                                    return false;
                                } else
                                    valid = true;
                            }

                            if (afterDot[1].charAt(0) == '-' || afterDot[1].charAt(0) == '+') {
                                for (int i = 1; i < afterDot[1].length(); i++) {
                                    if (allowedChars.indexOf(afterDot[1].charAt(i)) == -1) {
                                        return false;
                                    } else
                                        valid = true;
                                }

                            } else if (Character.isDigit(afterDot[1].charAt(0))) {
                                for (int i = 1; i < afterDot[1].length(); i++) {
                                    if (allowedChars.indexOf(afterDot[1].charAt(i)) == -1) {
                                        return false;
                                    } else
                                        valid = true;
                                }
                            }
                        }
                    } else {
                        if (str.charAt(1) == '.') {

                            for (int i = 0; i < str.length(); i++) {
                                if (allowedChars.indexOf(array[1].charAt(i)) == -1) {
                                    return false;
                                } else
                                    valid = true;
                            }
                        } else {

                            for (int i = 1; i < str.length(); i++) {
                                if (allowedChars.indexOf(array[0].charAt(i)) == -1) {
                                    return false;
                                } else
                                    valid = true;
                            }
                            for (int i = 0; i < str.length(); i++) {
                                if (allowedChars.indexOf(array[1].charAt(i)) == -1) {
                                    return false;
                                } else
                                    valid = true;
                            }

                        }
                    }
                } else if (!str.contains(".") && (str.contains("e")) && e) {
                    String[] array = str.split("e");

                    if (str.charAt(1) == 'e') {
                        if (array[1].charAt(0) == '-' || array[1].charAt(0) == '+') {
                            for (int i = 1; i < array[1].length(); i++) {
                                if (allowedChars.indexOf(array[1].charAt(i)) == -1) {
                                    return false;
                                } else
                                    valid = true;
                            }
                        } else {
                            for (int i = 0; i < array[1].length(); i++) {
                                if (allowedChars.indexOf(array[1].charAt(i)) == -1) {
                                    return false;
                                } else
                                    valid = true;
                            }
                        }
                    } else {
                        for (int i = 1; i < array[0].length(); i++) {
                            if (allowedChars.indexOf(array[0].charAt(i)) == -1) {
                                return false;
                            } else
                                valid = true;
                        }
                        if (array[1].charAt(0) == '-' || array[1].charAt(0) == '+') {
                            for (int i = 1; i < array[1].length(); i++) {
                                if (allowedChars.indexOf(array[1].charAt(i)) == -1) {
                                    return false;
                                } else
                                    valid = true;
                            }
                        } else {
                            for (int i = 0; i < array[1].length(); i++) {
                                if (allowedChars.indexOf(array[1].charAt(i)) == -1) {
                                    return false;
                                } else
                                    valid = true;
                            }
                        }

                    }
                } else {
                    for (int i = 1; i < str.length(); i++) {
                        if (allowedChars.indexOf(str.charAt(i)) == -1) {
                            return false;
                        } else
                            valid = true;
                    }
                }
            } else if (Character.isDigit(str.charAt(0)) || str.charAt(0) == '.' || str.charAt(0) == 'e') {
                String allowedChars = "0123456789";
                if (str.contains(".") && dot) {
                    String[] array = str.split("\\.");


                    if ((str.contains("e")) && e) {
                        if (str.charAt(0) == '.') {
                            String[] afterDot = array[1].split("e");

                            for (int i = 0; i < afterDot[0].length(); i++) {
                                if (allowedChars.indexOf(afterDot[0].charAt(i)) == -1) {
                                    return false;
                                } else
                                    valid = true;
                            }

                            if (afterDot[1].charAt(0) == '-' || afterDot[1].charAt(0) == '+') {
                                for (int i = 1; i < afterDot[1].length(); i++) {
                                    if (allowedChars.indexOf(afterDot[1].charAt(i)) == -1) {
                                        return false;
                                    } else
                                        valid = true;
                                }

                            } else if (Character.isDigit(str.charAt(0))) {
                                for (int i = 1; i < afterDot[1].length(); i++) {
                                    if (allowedChars.indexOf(afterDot[1].charAt(i)) == -1) {
                                        return false;
                                    } else
                                        valid = true;
                                }
                            }

                        } else {

                            for (int i = 0; i < array[0].length(); i++) {
                                if (allowedChars.indexOf(array[0].charAt(i)) == -1) {
                                    return false;
                                } else
                                    valid = true;
                            }
                            String[] afterDot = array[1].split("e");
                            for (int i = 0; i < afterDot[0].length(); i++) {
                                if (allowedChars.indexOf(afterDot[0].charAt(i)) == -1) {
                                    return false;
                                } else
                                    valid = true;
                            }

                            if (afterDot[1].charAt(0) == '-' || afterDot[1].charAt(0) == '+') {
                                for (int i = 1; i < afterDot[1].length(); i++) {
                                    if (allowedChars.indexOf(afterDot[1].charAt(i)) == -1) {
                                        return false;
                                    } else
                                        valid = true;
                                }

                            } else if (Character.isDigit(afterDot[1].charAt(0))) {
                                for (int i = 1; i < afterDot[1].length(); i++) {
                                    if (allowedChars.indexOf(afterDot[1].charAt(i)) == -1) {
                                        return false;
                                    } else
                                        valid = true;
                                }
                            }
                        }
                    } else {
                        if (str.charAt(0) == '.') {

                            for (int i = 0; i < array[1].length(); i++) {
                                if (allowedChars.indexOf(array[1].charAt(i)) == -1) {
                                    return false;
                                } else
                                    valid = true;
                            }
                        } else {

                            for (int i = 1; i < array[0].length(); i++) {
                                if (allowedChars.indexOf(array[0].charAt(i)) == -1) {
                                    return false;
                                } else
                                    valid = true;
                            }
                            for (int i = 0; i < str.length(); i++) {
                                if (allowedChars.indexOf(array[1].charAt(i)) == -1) {
                                    return false;
                                } else
                                    valid = true;
                            }

                        }
                    }
                } else if (!str.contains(".") && (str.contains("e")) && e) {
                    String[] array = str.split("e");

                    if (str.charAt(0) == 'e') {

                        if (array[1].charAt(0) == '-' || array[1].charAt(0) == '+') {
                            for (int i = 1; i < array[1].length(); i++) {
                                if (allowedChars.indexOf(array[1].charAt(i)) == -1) {
                                    return false;
                                } else
                                    valid = true;
                            }
                        } else {
                            for (int i = 0; i < array[1].length(); i++) {
                                if (allowedChars.indexOf(array[1].charAt(i)) == -1) {
                                    return false;
                                } else
                                    valid = true;
                            }
                        }
                    } else {
                        for (int i = 0; i < array[0].length(); i++) {
                            if (allowedChars.indexOf(array[0].charAt(i)) == -1) {
                                return false;
                            } else
                                valid = true;
                        }
                        if (array[1].charAt(0) == '-' || array[1].charAt(0) == '+') {
                            for (int i = 1; i < array[1].length(); i++) {
                                if (allowedChars.indexOf(array[1].charAt(i)) == -1) {
                                    return false;
                                } else
                                    valid = true;
                            }
                        } else {
                            for (int i = 0; i < array[1].length(); i++) {
                                if (allowedChars.indexOf(array[1].charAt(i)) == -1) {
                                    return false;
                                } else
                                    valid = true;
                            }
                        }

                    }
                }
            }
        } else {
            if (Character.isDigit(str.charAt(0))) {
                valid = true;
            }
        }
        return valid;
    }


    // This method returns whether the string data is keyword or not.
    public static boolean isKeyword(String str) {
        boolean valid = false;

        if (str.equals("define") || str.equals("let") || str.equals("cond") || str.equals("if")
                || str.equals("begin")) {
            valid = true;
        }

        return valid;
    }



    // This method returns keyword type.
    public static String keyword(String str) {

        String keywordType = "";

        if (str.equals("define")) {
            keywordType = "DEFINE";
        } else if (str.equals("let")) {
            keywordType = "LET";
        } else if (str.equals("cond")) {
            keywordType = "COND";
        } else if (str.equals("if")) {
            keywordType = "IF";
        } else if (str.equals("begin")) {
            keywordType = "BEGIN";
        }

        return keywordType;
    }


    // This method returns whether the string data is char or not.
    public static boolean isChar(String str) {
        boolean valid = false;

        if (str.length() == 4 || str.length() == 3) {
            if (str.length() == 4) {
                if (str.charAt(0) == '\'' && str.charAt(3) == '\'') {
                    if (str.charAt(1) == '\\') {
                        if (str.charAt(2) == '\\') {
                            valid = true;
                        } else if (str.charAt(2) == '\'') {
                            valid = true;
                        }else{
                            return false;
                        }
                    }

                }
            } else {
                if (str.charAt(0) == '\'' && str.charAt(2) == '\'') {
                    if (str.charAt(1) != ' ') {
                        valid = true;
                    }else {
                        return false;
                    }
                }
            }
        } else
            return false;
        return valid;
    }

    public static String str(String[] str, int num) {
        String newStr=str[num];

        if(str.length>0) {
            for (int j = num + 1; j < str.length; j++) {
                //System.out.println(j+":"+str[j]+" length:"+str[j].length());
                if(str[j].length()>2){
                    if(str[j].charAt(str[j].length()-1)!='"' && str[j].charAt(str[j].length()-2)!='"' && str[j].charAt(str[j].length()-3)!='\\'){
                        newStr+=" "+str[j];
                        //rp++;
                    }else if(str[j].charAt(str[j].length()-1)=='"' && str[j].charAt(str[j].length()-2)!='"' ){
                        newStr+=" "+str[j];
                        //rp++;

                    }else{
                        newStr+=" "+str[j];
                        //rp++;
                        break;
                    }

                }else if(str[j].length()==2){
                    if(str[j].charAt(1)=='"' && str[j].charAt(0)!='\\'){
                        newStr+=" "+str[j];
                        //rp++;
                        break;
                    }else{
                        newStr+=" "+str[j];
                        //rp++;
                    }

                }else{
                    if(str[j].charAt(0)!='"' || str[j].charAt(0)!='\\'){
                        newStr+=" "+str[j];
                        //rp++;
                    }else{
                        newStr+=" "+str[j];
                        //rp++;
                        break;
                    }
                }


            }
        }



        return newStr;
    }
    // This method returns whether the string data is string or not.
    public static boolean isStr(String[] str, int num) {
        String newStr=str[num];

        if(str.length>0) {
            for (int j = num + 1; j < str.length; j++) {
                //System.out.println(j+":"+str[j]+" length:"+str[j].length());
                if(str[j].length()>2){
                    if(str[j].charAt(str[j].length()-1)!='"' && str[j].charAt(str[j].length()-2)!='"' && str[j].charAt(str[j].length()-3)!='\\'){
                        newStr+=" "+str[j];
                        //rp++;
                    }else if(str[j].charAt(str[j].length()-1)=='"' && str[j].charAt(str[j].length()-2)!='"' ){
                        newStr+=" "+str[j];
                        //rp++;

                    }else{
                        newStr+=" "+str[j];
                        //rp++;
                        break;
                    }

                }else if(str[j].length()==2){
                    if(str[j].charAt(1)=='"' && str[j].charAt(0)!='\\'){
                        newStr+=" "+str[j];
                        //rp++;
                        break;
                    }else{
                        newStr+=" "+str[j];
                        //rp++;
                    }

                }else{
                    if(str[j].charAt(0)!='"' || str[j].charAt(0)!='\\'){
                        newStr+=" "+str[j];
                        //rp++;
                    }else{
                        newStr+=" "+str[j];
                        //rp++;
                        break;
                    }
                }


            }
        }
        //String[] rStr=newStr.split(" ");
        if(newStr.charAt(0)=='"' && newStr.charAt(newStr.length()-1)=='"'){
            return true;

        }

        return false;
    }


    // This method returns bracket type.
    public static String brackets(char c) {

        String bracketType = "";
        if (c == '(') {
            bracketType = "LEFTPAR";
        } else if (c == ')') {
            bracketType = "RIGHTPAR";
        } else if (c == '[') {
            bracketType = "LEFTSQUAREB";
        } else if (c == ']') {
            bracketType = "RIGHTSQUAREB";
        } else if (c == '{') {
            bracketType = "LEFTCURLYB";
        } else if (c == '}') {
            bracketType = "RIGHTCURLYB";
        }
        return bracketType;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Input file name : ");
        String inputFile = input.next();

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(inputFile)))) {
            PrintStream writeToTxt = new PrintStream(new FileOutputStream("output.txt", false));
            int row = 1;

            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();

                String sp = str.trim();
                String[] stringArray = sp.split(" "); //
                //System.out.println("length: " + stringArray.length + " ");

                String newStr = sp.replaceAll("[\\[\\]\\{\\}\\(\\)]", "");
                String[] arr = newStr.split(" ");

                int column;
                int repeat, repeat1, repeat2, repeat3, repeat4, repeat5, repeat6, repeat7, repeat8, repeat9, repeat10;
                repeat = repeat1 = repeat2 = repeat3 = repeat4 = repeat5 = repeat6 = repeat7 = repeat8 = repeat9 = repeat10= 0;
                int cl;
                int[] array= new int[stringArray.length];

                String sb;
                for (int j = 0; j < stringArray.length; j++) {
                    for (int i = 0; i < stringArray[j].length(); i++) {

                            if (stringArray[j].charAt(i) == '(') {
                                column = (str.indexOf('(') + 1);
                                sb = str;
                                cl = 0;
                                if (repeat > 0) {
                                    for (int k = 0; k < repeat; k++) {
                                        sb = str.substring(column + cl);
                                        cl += (sb.indexOf('(') + 1);
                                    }

                                }
                                repeat++;
                                System.out.println(brackets(stringArray[j].charAt(i)) + " " + row + ":" + (column + cl));
                                writeToTxt.println(brackets(stringArray[j].charAt(i)) + " " + row + ":" + (column + cl));

                            } else if (stringArray[j].charAt(i) == ')') {
                                column = (str.indexOf(')') + 1);
                                sb = str;
                                cl = 0;
                                if (repeat1 > 0) {
                                    for (int a = 0; a < repeat1; a++) {
                                        sb = str.substring(column + cl);
                                        cl += (sb.indexOf(')') + 1);
                                    }
                                } //
                                System.out.println(brackets(stringArray[j].charAt(i)) + " " + row + ":" + (column + cl));
                                writeToTxt.println(brackets(stringArray[j].charAt(i)) + " " + row + ":" + (column + cl));
                                repeat1++;
                            } else if (stringArray[j].charAt(i) == '[') {
                                column = (str.indexOf('[') + 1);
                                sb = str;
                                cl = 0;
                                if (repeat2 > 0) {
                                    for (int a = 0; a < repeat2; a++) {
                                        sb = str.substring(column + cl);
                                        cl += (sb.indexOf('[') + 1);
                                    }
                                }
                                repeat2++;
                                System.out.println(brackets(stringArray[j].charAt(i)) + " " + row + ":" + (column + cl));
                                writeToTxt.println(brackets(stringArray[j].charAt(i)) + " " + row + ":" + (column + cl));
                            } else if (stringArray[j].charAt(i) == ']') {
                                column = (str.indexOf(']') + 1);
                                sb = str;
                                cl = 0;
                                if (repeat3 > 0) {
                                    for (int a = 0; a < repeat3; a++) {
                                        sb = str.substring(column + cl);
                                        cl += (sb.indexOf(']') + 1);
                                    }
                                }
                                repeat3++;
                                System.out.println("IDENTIFIER" + " " + row + ":" + (column + cl));
                                writeToTxt.println(brackets(stringArray[j].charAt(i)) + " " + row + ":" + (column + cl));
                            } else if (stringArray[j].charAt(i) == '{') {
                                column = (str.indexOf('{') + 1);
                                sb = str;
                                cl = 0;
                                if (repeat4 > 0) {
                                    for (int a = 0; a < repeat4; a++) {
                                        sb = str.substring(column + cl);
                                        cl += (sb.indexOf('{') + 1);
                                    }
                                }
                                repeat4++;
                                System.out.println("IDENTIFIER" + " " + row + ":" + (column + cl));
                                writeToTxt.println(brackets(stringArray[j].charAt(i)) + " " + row + ":" + (column + cl));
                            } else if (stringArray[j].charAt(i) == '}') {
                                column = (str.indexOf('}') + 1);
                                sb = str;
                                cl = 0;
                                if (repeat5 > 0) {
                                    for (int a = 0; a < repeat5; a++) {
                                        sb = str.substring(column + cl);
                                        cl += (sb.indexOf('}') + 1);
                                    }
                                }
                                repeat5++;
                                System.out.println(brackets(stringArray[j].charAt(i)) + " " + row + ":" + (column + cl));
                                writeToTxt.println(brackets(stringArray[j].charAt(i)) + " " + row + ":" + (column + cl));
                            } else if (isKeyword(arr[j]) && stringArray[j].charAt(i) == arr[j].charAt(0)) {
                                array[repeat6]=j;
                                sb = str;
                                column=0;
                                cl = 0;
                                if (repeat6 > 0) {
                                    for(int a=0; a<repeat6;a++){
                                        if (arr[array[a]].equals(arr[j])) {
                                            column = str.indexOf(arr[array[a]]) + 1;
                                            sb = str.substring(column + cl);
                                            cl += sb.indexOf(arr[array[a]]) + 1;
                                        }else{
                                            column=str.indexOf(arr[j]) + 1;
                                        }
                                    }
                                }else if (repeat6 == 0) {
                                    cl=0;
                                    column=str.indexOf(arr[j]) + 1;

                                }
                                System.out.println(keyword(arr[j]) + " " + row + ":" + (column + cl));
                                writeToTxt.println(keyword(arr[j]) + " " + row + ":" + (column + cl));
                                repeat6++;
                            } else if (isNumber(arr[j].toLowerCase()) && stringArray[j].charAt(i) == arr[j].charAt(0)) {
                                array[repeat7]=j;
                                sb = str;
                                column=0;
                                cl = 0;
                                if (repeat7 > 0) {
                                    for(int a=0; a<repeat7;a++){
                                        if (arr[array[a]].equals(arr[j])) {
                                            column = str.indexOf(arr[array[a]]) + 1;
                                            sb = str.substring(column + cl);
                                            cl += sb.indexOf(arr[array[a]]) + 1;
                                        }else{
                                            column=str.indexOf(arr[j]) + 1;
                                        }
                                    }
                                }else if (repeat7 == 0) {
                                    cl=0;
                                    column=str.indexOf(arr[j]) + 1;

                                }
                                System.out.println("NUMBER" + " " + row + ":" + (column + cl));
                                writeToTxt.println("NUMBER" + " " + row + ":" + (column + cl));
                                repeat7++;
                            } else if (isBoo(arr[j])) {
                                column = str.indexOf(stringArray[j].charAt(i)) + 1;
                                sb = str;
                                cl = 0;
                                if (repeat8 > 0) {
                                    for (int a = 0; a < repeat8; a++) {
                                        sb = str.substring(column + cl);
                                        cl += (sb.indexOf(stringArray[j].charAt(i)) + 1);
                                    }
                                }
                                System.out.println("BOOLEAN" + " " + row + ":" + (column + cl));
                                writeToTxt.println("BOOLEAN" + " " + row + ":" + (column + cl));
                                repeat8++;

                            }else if (isStr(arr,j) && stringArray[j].charAt(i) == '"') {
                                if(i==0){
                                    column = str.indexOf(arr[j]) + 1;
                                    System.out.println("STRING" + " " + row + ":" + column);
                                    writeToTxt.println("STRING" + " " + row + ":" + column);
                                }

                            }else if (isIdentifier(arr[j]) && stringArray[j].charAt(i) == arr[j].charAt(0)) {
                                if(!(str(arr,j).contains(arr[j]))){
                                    column = str.indexOf(stringArray[j].charAt(i)) + 1;
                                    sb = str;
                                    cl = 0;
                                    if (repeat9 > 0) {
                                        for (int a = 0; a < repeat9; a++) {
                                            sb = str.substring(column + cl);
                                            cl += (sb.indexOf(stringArray[j].charAt(i)) + 1);
                                        }
                                    }
                                    System.out.println("IDENTIFIER" + " " + row + ":" + (column + cl));
                                    writeToTxt.println("IDENTIFIER" + " " + row + ":" + (column + cl));
                                    repeat9++;

                                }

                            }else if (isChar(arr[j]) && stringArray[j].charAt(i) == arr[j].charAt(0)) {
                                array[repeat10]=j;
                                sb = str;
                                column=0;
                                cl = 0;
                                if (repeat10 > 0) {
                                    for(int a=0; a<repeat10;a++){
                                        if (arr[array[a]].equals(arr[j])) {
                                            column = str.indexOf(arr[array[a]]) + 1;
                                            sb = str.substring(column + cl);
                                            cl += sb.indexOf(arr[array[a]]) + 1;
                                        }else{
                                            column=str.indexOf(arr[j]) + 1;
                                        }
                                    }
                                }else if (repeat10 == 0) {
                                    cl=0;
                                    column=str.indexOf(arr[j]) + 1;

                                }
                                System.out.println("CHAR" + " " + row + ":" + (column + cl));
                                writeToTxt.println("CHAR" + " " + row + ":" + (column + cl));
                                repeat10++;
                            }/*else{
                                column=str.indexOf(arr[j]) + 1;
                                System.out.println("LEXICAL ERROR [" + row +":"+ (column) + "]: Invalid token " + "'" + arr[j] + "'" );
                                System.exit(0);
                            }*/
                    }

                }

                row++;

            }
            writeToTxt.close();
            input.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
