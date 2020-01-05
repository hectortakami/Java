
import javafx.util.converter.FormatStringConverter;
import sun.rmi.server.UnicastServerRef;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hector
 */
public class Main {
    
    
    
    public static TNode<Character> buildExpTree(String postFixExp){
        TNode<Character> newNode, newLeft, newRight;
        char token;
        AlStack<TNode<Character>> s = new AlStack<>();
        int i = 0, n = postFixExp.length();
        while (i!=n)
        {
            while (postFixExp.charAt(i)== ' ' || postFixExp.charAt(i) == '\t')
            i++;
            
            if (i==n)
                break;
            
            token = postFixExp.charAt(i);
            i++;
            
            if (token == '+' || token == '-' || token == '*' || token == '/'){
                newRight = s.pop();
                newLeft = s.pop();
                
                newNode = new TNode<Character>(token,newLeft,newRight);
                s.push(newNode);
            }else{
                newNode = new TNode<>(token);
                s.push(newNode);
            }
        }
        
        if (!s.isEmpty()){
            return s.pop();
        }else{
            return null;
        }
    }
    
    private static <T> TNodeShadow builtShadowTree(TNode<T> t, int level){
        TNodeShadow newNode = null;
        String str;
        if (t !=null){
            newNode = new TNodeShadow();
            TNodeShadow newLeft = builtShadowTree(t.left, level+1);
            newNode.left = newLeft;
            
            str = (t.nodeValue).toString();
            newNode.nodeValueStr = str;
            newNode.level = level;
            newNode.colum = TNodeShadow.columValue;
            
            TNodeShadow.columValue++;
            TNodeShadow newRight = builtShadowTree(t.right, level+1);
            newNode.right = newRight;
        }
        return newNode;
    }
    
    public static <T> String displayTree(TNode<T> t, int maxCharacters){
        LinkedQueue<TNodeShadow> q = new LinkedQueue<>();
        String displayStr = "";
        int colWidth = maxCharacters+1;
        int currLevel = 0, currCol = 0;
        
        TNodeShadow.columValue = 0;
        if (t==null)
            return displayStr;
        
        TNodeShadow shadowRoot = builtShadowTree(t,0);
        TNodeShadow currNode;
        
        q.push(shadowRoot);
        while (!q.isEmpty()){
            currNode = q.pop();
            if (currNode.level>currLevel){
                currLevel = currNode.level;
                currCol = 0;
                displayStr += "\n";
            }
            if (currNode.left!=null)
                q.push(currNode.left);
            if (currNode.right!=null)
                q.push(currNode.right);
            
            if (currNode.colum>currCol){
                displayStr+= formatChar((currNode.colum-currCol) * colWidth, ' ');
                currCol = currNode.colum;
            }
            displayStr += formatString (colWidth, currNode.nodeValueStr);
            currCol++;
        }
        displayStr += "\n";
        shadowRoot = clearShadowTree(shadowRoot);
        return displayStr;
        
    }
    
    private static TNodeShadow clearShadowTree(TNodeShadow t)
        {
           // if current root node is not null, delete its left subtree,
           // its right subtree and then the node itself
           if (t != null)
           {
              t.left = clearShadowTree(t.left);
              t.right = clearShadowTree(t.right);
              return null;
           }
           else
              return null;
        }
    
   private static String formatString(int w, String s)
	{
		// capture the length of s
		int sLength = s.length();

		// if length of s is at least w, just return s
		if (sLength >= w)
			return s;

		String str = "";

		// append w - sLength blanks to str
		for (int i=0;i < w - sLength;i++)
			str += " ";
		// append s after the leading blanks
		str += s;

		// return the formatted string
		return str;
	}
    
    private static String formatChar(int w, char ch)
	{
		String str = "";

		// append w - sLength blanks to str
		for (int i=0;i < w - 1;i++)
			str += " ";
		// append ch after the leading blanks
		str += ch;

		// return the formatted string
		return str;
	}
    
    public static void main(String[] args) {
        String x = "abcde****";
        TNode root = buildExpTree(x);
        System.out.println(displayTree(root, 5));
        
        
    }
}
