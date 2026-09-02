#include<iostream>
using namespace std;

class Library{
    string song;

public:
    void like(){
        cout <<"Enter song name ";
        cin >> song;
    }
    string getSong(){
        return song;
    }

};

class Playlist{
public:
    void add(Library &song){
        cout << song.getSong() << " added to playlist" << endl;
    }
};
int main(){
    Library song;
    Playlist playlist;
    
    song.like();    
    playlist.add(song);
    return 0;
}