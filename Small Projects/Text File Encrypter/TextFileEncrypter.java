import java.io.*;

public class TextFileEncrypter {
    public static void main(String[] args) {
        String fileName = "temp.txt";
        encryptTextFile(fileName);
    }

    public static void encryptTextFile(String fileName) {
        String line = null;
        String allText = "";
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                allText = allText + line + " ";
            }
            bufferedReader.close();
            Huffman hm = new Huffman();
            hm.buildCode(allText);
            hm.printEncoded();
        }
        catch (FileNotFoundException ex) {
            System.out.println("Unable to open " + fileName);
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }
}
