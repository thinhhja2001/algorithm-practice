#include <iostream>
using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
};

ListNode *createNode(int value)
{
    ListNode *p = new ListNode();
    p->val = value;
    p->next = NULL;
    return p;
}

void insert(ListNode *p, int value)
{
    ListNode *newNode = createNode(value);
    if (p == NULL)
    {
        p = newNode;
        return;
    }
    while (p->next != NULL)
    {
        p = p->next;
    }
    p->next = newNode;
}

void printNode(ListNode *p)
{
    while (p != NULL)
    {
        cout << p->val << " ";
        p = p->next;
    }
}

ListNode *reverseLinkedList(ListNode *p)
{
    ListNode *q;
    while (p != NULL)
    {
        if (q == NULL)
        {
            q = new ListNode();
            q->val = p->val;
        }
        else
        {

            ListNode *newNode = new ListNode();
            newNode->val = p->val;
            newNode->next = q;
            q = newNode;
        }
        p = p->next;
    }
    return q;
}

int main(int argc, char const *argv[])
{
    ListNode *p = new ListNode();
    insert(p, 3);
    insert(p, 4);
    insert(p, 5);
    ListNode *q = reverseLinkedList(p);
    printNode(q);
    return 0;
}
