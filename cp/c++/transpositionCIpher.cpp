// both 3 and 4 in this code

#include <bits/stdc++.h>
using namespace std;

string transposeCipher(string text, int width)
{
    string result = "";
    int col = 0, i = 0;
    while (col < width)
    {
        result += text[i];
        i += width;
        if (i >= text.size())
        {
            i = ++col;
        }
    }
    return result;
}

string decrypt(string text, int width)
{
    string result=text;
    int col = 0, j = 0;
    for (int i = 0; i < text.size(); i++)
    {
        result[j] = text[i];
        j += width;
        if (j >= text.length())
        {
            j = ++col;
        }
    }
    return result;
}

int main()
{
    freopen("transpose.txt", "r", stdin);

    string text;
    getline(cin, text);

    int width = 4;

    string enc = transposeCipher(text, width);
    string enc2 = transposeCipher(enc, 2 * width);

    cout<<"Original Text : "<<text<<endl;
    cout << "First Transposition Cipher: " << enc << endl;
    cout << "Double Transposition Cipher: " << enc2 << endl;

    string dec = decrypt(enc2, 2 * width);
    string dec2 = decrypt(dec, width);

    cout << "Decrypted Text: " << dec2 << endl;

    return 0;
}
