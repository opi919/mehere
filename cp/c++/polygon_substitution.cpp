#include<bits/stdc++.h>
using namespace std;

map<string, string> encoder;
map<string, string> decoder;

string cipherText(string &str)
{
    string cipher, temp;

    for (int i=0;i<str.size();i++)
    {
        char ch=str[i];
        if (isalpha(ch))
        {
            temp += ch;
            if (encoder.find(temp) != encoder.end())
            {
                cipher += encoder[temp];
                temp="";
            }
        }
        else
        {
            cipher += ch;
        }
    }

    return cipher;
}

string decipherText(string &str)
{
    string decipher, temp;

    for (int i = 0; i < str.size(); i++)
    {
        char ch = str[i];
        if (isalpha(ch))
        {
            temp += ch;
            if (decoder.find(temp) != decoder.end())
            {
                decipher += decoder[temp];
                temp="";
            }
        }
        else
        {
            decipher += ch;
        }
    }

    return decipher;
}

int main()
{
    freopen("polygon.txt","r",stdin);

    string str;
    getline(cin, str); // Read the first line of the file
    cin.clear();
    freopen("dictionary.txt","r",stdin);
    string s1, s2,text;
    while (cin >> s1 >> s2)
    {
        encoder[s1] = s2;
        decoder[s2] = s1;
    }
    int block_size=3;
    // Perform encryption and decryption
    string cipher = cipherText(str);
    string decipher = decipherText(cipher);

    // Output the results
    cout << "Plain-Text: " << str << endl;
    cout << "Cipher-Text: " << cipher << endl;
    cout << "Decipher-Text: " << decipher << endl;

    return 0;
}
