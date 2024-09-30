#include <bits/stdc++.h>

using namespace std;

string cipherText(string str, string key)
{
    string cipher = "";
    for (size_t i = 0; i < str.length(); i++)
    {
        char ch = str[i];
        if (isupper(ch))
        {
            ch = (ch - 'A' + key[i] - 'A') % 26 + 'A';
        }
        else if (islower(ch))
        {
            ch = (ch - 'a' + key[i] - 'A') % 26 + 'a';
        }
        cipher += ch;
    }
    return cipher;
}

string decipherText(string str, string key)
{
    string decipher = "";
    for (size_t i = 0; i < str.length(); i++)
    {
        char ch = str[i];
        if (isupper(ch))
        {
            ch = (ch - 'A' - key[i] + 'A' + 26) % 26 + 'A';
        }
        else if (islower(ch))
        {
            ch = (ch - 'a' - key[i] + 'A' + 26) % 26 + 'a';
        }
        decipher += ch;
    }
    return decipher;
}

int main()
{
    freopen("onetimepad.txt", "r", stdin);

    string key;
    getline(cin, key);

    string text = "DEPARTMENT OF COMPUTER SCIENCE AND ENGINEERING";

    string cipher = cipherText(text, key);
    string decipher = decipherText(cipher, key);

    cout << "Plain-Text: " << text << endl;
    cout << "Cipher-Text: " << cipher << endl;
    cout << "Decipher-Text: " << decipher << endl;

    return 0;
}

// must key.length > text.length
