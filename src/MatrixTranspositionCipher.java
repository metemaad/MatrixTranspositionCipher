import java.util.Vector;

/**
 * Created by mohammad on 3/12/17.
 */
public class MatrixTranspositionCipher {


    char[] _message;
    char[] _cipherMessage;

    void Set_cipherMessage(String cipher)
    {
        _cipherMessage=cipher.toCharArray();

    }

    void Set_message(String message)
    {
        _message=message.toCharArray();
    }
    void setSecretKey(Vector<Integer> key)
    {
        SecretKey=key;
    }
    Vector<Integer> SecretKey=new Vector<>();
    char space='%';
    String Encryption()
    {
        _message=replaceSpace(String.valueOf(_message)).toCharArray();
        String ret="";

        for(int i=0;i<=SecretKey.size()-1;i++)
        {
            int k=SecretKey.get(i);
            for(int j=0;j<=_message.length-1;j++)
            {
                if (j%(SecretKey.size())== k-1)
                {
                    ret+=_message[j];
                }

            }

        }

        return ret;
    }

    String Decryption()
    {

        String ret="";

        Vector<String> st=new Vector<>(SecretKey.size());

        for(int j=0;j<=SecretKey.size()-1;j++)
        {
            st.add(j,String.valueOf(_cipherMessage).substring(j*SecretKey.size(),j*SecretKey.size()+SecretKey.size()));


        }

        for(int j=0;j<=(_cipherMessage.length/SecretKey.size())-1;j++)
        {
            for(int i=1;i<=SecretKey.size();i++) {
                int k = SecretKey.indexOf(i);
                char[] s = st.get(k).toCharArray();
                ret += s[j];
            }

        }
        return ret.replace("%"," ");
    }
    String replaceSpace(String s)
    {
        String ret="";
        for (char c:s.toCharArray()
             ) {
            if (c==' ')
            {
                c=space;
            }
            ret+=c;

        }
        if (ret.length()%SecretKey.size()!=0)
        {
            int l=(SecretKey.size()-ret.length()%SecretKey.size());
            for(int i=0;i<l;i++)
            {
                ret+=space;
            }

        }
        return ret;

    }

}
