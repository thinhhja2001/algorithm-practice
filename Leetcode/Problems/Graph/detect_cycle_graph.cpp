// ConsoleApplication1.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector>
#include <math.h>
#include <unordered_map>
#include <unordered_set>
#include <set>
#include<stack>
#include <algorithm>
#include <queue>
using namespace std;

struct Edge {
	int src, dest;
};
bool contains(vector<int>arr, int value) {
	for (int i = 0; i < arr.size(); i++) {
		if (arr[i] == value)return true;
	}
	return false;
}

class Graph {
public:
	vector<vector<int>>adjList;
	Graph(vector<Edge>edges, int n) {
		adjList.resize(n);
		for (Edge edge : edges) {
			adjList[edge.src].push_back(edge.dest);
		}
	}
	Graph(vector<vector<int>>edges, int maxVertex) {
		adjList.resize(maxVertex + 1);
		for (int i = 0; i < edges.size(); i++) {
			adjList[edges[i][0]].push_back(edges[i][1]);
			adjList[edges[i][1]].push_back(edges[i][0]);
		}
	}

	bool isCycle() {
		for (int i = 0; i < adjList.size(); i++) {
			vector<int>visited;
			visited.resize(adjList.size(), false);
			if (isCycleUtil(-1, i, visited))return true;
		}
		return false;
	}
	bool isCycleUtil(int parent, int value, vector<int>& visited) {
		visited[value] = true;
		for (auto it = adjList[value].rbegin(); it != adjList[value].rend(); it++) {
			int u = *it;
			//
			// 1: 2,3,4
			// 2: 1,2
			// If we start from 1, we will have to check the edge of (1,2), and then we start from 2, we will have to check
			// the edge of (2,1) which will cause the unwanted cycle. Because of that, we will ignore the parent value of the next node
			//
			if (u == parent)continue;
			if (u != parent && visited[u])return true;
			return isCycleUtil(value, u, visited);
		}
		return false;
	}
};





int  main()
{
	vector<vector<int>>edges = { {1,2},{2,3},{3,4} };
	int maxVertex = 4;
	Graph g(edges, maxVertex);
	cout << boolalpha << g.isCycle();
};



// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
