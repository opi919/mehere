#include<bits/stdc++.h>
using namespace std;

string encrypt(string text, int shift)
{
    string str = "";
    for(int i=0; i<text.size(); i++)
    {
        if(isupper(text[i]))
        {
            char ch = (text[i]+shift-'A')%26 + 'A';
            str+=ch;
        }
        else if(islower(text[i]))
        {
            char ch = (text[i]+shift-'a')%26 + 'a';
            str+=ch;
        }
        else
            str+=text[i];
    }
    return str;
}


int main()
{
    freopen("caesar.txt","r",stdin);
    string text,str;
    cout<<"Enter your original text: ";
    getline(cin, text); // i think sir give us input in one line if not then the procedure will given below
    /*
    while (getline(cin, text)) {
        str+=text;
        }
        shift=4; //manually
    */

    int shift;
    cout<<"Enter how many shift to the right: ";
    cin>>shift;
    shift = shift%26;
    cout<<endl<<endl;
    cout<<"Plain Text: "<<text<<endl;

    string chiper = encrypt(text, shift);
    cout << "Encrypted Cipher: " << chiper <<endl;

    string original = encrypt(chiper, 26 - shift);
    cout << "decrypted Cipher: " << original << endl;
    return 0;
}