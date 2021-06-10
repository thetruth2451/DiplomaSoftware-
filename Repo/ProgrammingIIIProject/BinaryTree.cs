using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Project
{
    class BinaryTree
    {
        //The root node contains the begining of the binary tree which as many branches and branches of branches
        private TreeNode root;
        //The search root contains the root which will be used to search or delete
        private TreeNode searchRoot;
        private List<string> orderedNames = new List<string>();

        public List<string> returnOrderedNames()
        {
            return orderedNames;
        }
        public TreeNode returnSearchRoot()
        {
            return searchRoot;
        }
        //Functions sets the root 
        public void SetRoot(TreeNode tempRoot)
        {
            root = tempRoot;
        }
        //Function sets the search root which will be used to search or delete
        public void SetForSearch(TreeNode node)
        {
            searchRoot = node;
        }

        //Get root returns the root
        public TreeNode GetRoot()
        {
            return root;
        }

        //This function creates a balanced binary tree without having to create a seperate insert function
        //This function sorts and inserts the binary tree meaning that a seperate function which converts a tree
        //Is not needed, 
        public TreeNode createBalancedTree(string[] nameIndexArray, int start, int end)
        {

            if (start > end) { return null; }
            else
            {
                int mid = start + (end - start) / 2;
                TreeNode currentNode = new TreeNode(nameIndexArray[mid - 1]);
                //The result is a balanced binary tree which is temporailty stored in the root node
                //And stored for more time within the searchRoot
                if (root == null)
                {
                    root = currentNode;

                }
                //This is a recursive method which continues to create branches until no
                //more branches are needed to store all of the data within the name array
                currentNode.SetLeftNode(createBalancedTree(nameIndexArray, start, mid - 1));
                currentNode.SetRightNode(createBalancedTree(nameIndexArray, mid + 1, end));
                //the return method is not used for the end of the createBalanceTree function
                //the return method is only used for creating branch nodes
                return currentNode;
            }

        }

        //The search function takes a balanced binary tree and recursiviely
        //Checks if the search tree is in each node
        public TreeNode Search(string name)
        {
            //If the search root has already been inserted
            if (searchRoot != null)
            {
                return searchRoot.Search(name);
            }
            //If the add button hasnt been used return null signifing that 
            //The add button must be clicked first
            else
            {
                return null;
            }

        }
    }
}
