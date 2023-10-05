// ConsoleApplication1.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector>
#include <math.h>
#include <unordered_map>
#include <unordered_set>

using namespace std;

struct Node {
public:
	vector<Node*>children;
	bool isWord;
	Node() {
		children = vector<Node*>(26, NULL);
		isWord = false;
	}
};

class Trie {
public:
	Node* root;

	Trie() {
		root = new Node();
	}

	void insert(string s) {
		Node* node = root;
		node->isWord = false;
		for (int i = 0; i < s.size(); i++) {
			if (root->isWord)return;
			int c = s[i] - 'a';
			if (root->children[c] == nullptr) {
				node->children[c] = new Node();
			}
			node = node->children[c];
		}
		node->isWord = true;
	}
	string findClosest(string s) {
		Node* node = root;
		for (int i = 0; i < s.size(); i++) {
			int c = s[i] - 'a';
			if (node->children[c] == nullptr) return s;
			else {
				node = node->children[c];
				if (node->isWord)return s.substr(0, i + 1);
			}
		}
		return s;
	}
};
class Solution {
public:
	vector<string>splitWhiteSpace(string str) {
		vector<string>token;
		string word = "";
		for (int i = 0; i < str.size(); i++) {
			if (str[i] == ' ') {
				token.push_back(word);
				word = "";
			}
			else {
				word += str[i];
			}
		}
		token.push_back(word);
		return token;
	}

	string replaceWords(vector<string>dictionary, string sentence) {
		string result = "";
		Trie* t = new Trie();
		for (string s : dictionary) {
			t->insert(s);
		}
		vector<string>tokens = splitWhiteSpace(sentence);


		for (string token : tokens) {
			string replacedWord = t->findClosest(token);
			result += replacedWord + " ";
		}
		result = result.substr(0, result.length() - 1);
		return result;
	}
};



int  main()
{

	//vector<string>dictionary = { "a","b","c" };
	//string sentence = "aadsfasf absbs bbab cadsfafs";
	vector<string>dictionary = { "a","aa" };
	string sentence = "the cattle was rattled by the battery";
	Solution s;
	cout << s.replaceWords(dictionary, sentence);

}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
