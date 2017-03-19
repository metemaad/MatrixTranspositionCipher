import java.util.Scanner;
import java.util.Vector;

/**
 *Write a program to encrypt and decrypt strings of characters using the following ciphers:(Minimum alphabet)
 *
 *b) Vigenere cipher
 *
 * Created by mohammad on 3/12/17.
 */
public class main {

    public static void main(String[] args) {



        System.out.print("\n***************************");
        System.out.print("\nMatrix Transposition Cipher");
        System.out.print("\n***************************");
        MatrixTranspositionCipher c=new MatrixTranspositionCipher();
        Scanner scan2 = new Scanner(System.in);

        System.out.print("\nPlain text:");
        String m = scan2.nextLine();
        c.Set_message(m);

        scan2 = new Scanner(System.in);
        System.out.print("\nplease enter your key e.g. 3,4,1,2 :");
        String key = scan2.nextLine();
        String[] st=key.split(",");
        Vector<Integer> tmp=new Vector<>();
        int j=0;
        for (String s:st ) {
            tmp.add(j,Integer.parseInt(s));
            j++;
        }
        c.setSecretKey(tmp);

        String ct=c.Encryption();
        System.out.print("\nEncrypted text: "+ct+"\n");


        System.out.print("\nTest 2:\n");

        scan2 = new Scanner(System.in);
        System.out.print("\nCipher text:");
        m = scan2.nextLine();
        c.Set_cipherMessage(m);


        scan2 = new Scanner(System.in);
        System.out.print("\nplease enter your key e.g. 3,4,1,2 :");
        key = scan2.nextLine();

        st=key.split(",");
        tmp=new Vector<>();
        j=0;
        for (String s:st ) {
            tmp.add(j,Integer.parseInt(s));
            j++;
        }
        c.setSecretKey(tmp);



        ct=c.Decryption();
        System.out.print("\nDecripted text: "+ct+"\n");


    }
}
