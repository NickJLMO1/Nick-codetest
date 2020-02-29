import java.util.*;

public class WordFinder {


    private static int idCounter = 0;
    public List<String> findWords(String input, Dictionary dic)
    {

        List<String> resultList = new ArrayList<String>() ;
        HashSet<String> hs = new HashSet<String>(dic.getDictionaryWords());//filter duplicate words

        TreeNode rootNode = new TreeNode("0","","");//create the root node
        ArrayList<TreeNode>  treeNodeList = getNodeList(input,hs,rootNode) ;// build tree elements
        treeNodeList.add(rootNode);
        DictionaryTree dictionaryTree = new DictionaryTree();
        dictionaryTree.switchNodeListToTree(treeNodeList);

         HashMap<String,TreeNode> treeElement = dictionaryTree.getTreeElement();
         HashMap<String,TreeNode> treeEndNodeElements = dictionaryTree.getEndNodes();


         boolean wrongSentence = true;
         for(TreeNode tn: treeEndNodeElements.values())
         {
           Stack<String>  stack = new Stack<String>();
           String parentId = tn.getParentId();
           stack.push(tn.getData());
           while(!"0".equals(parentId))
           {
               TreeNode pn = treeElement.get(parentId);
               stack.push(pn.getData());
               parentId = pn.getParentId();
           }

           String compareString = "";
           String breakSentence = "";
           while (!stack.isEmpty())
           {
               String value = stack.pop();
               breakSentence = breakSentence + " " + value;
               compareString = compareString+value;
           }
           if(compareString.equals(input))
           {
               wrongSentence = false;
               resultList.add(breakSentence);
               //System.out.println(breakSentence);
           }

        }
        if(wrongSentence)
        {
            resultList.add(input + " is not a valid sentence!");
            //System.out.println(input + " is not a valid sentence!");
        }
        return resultList;
    }

    //build tree nodes
    private ArrayList<TreeNode> getNodeList (String input, HashSet<String> words, TreeNode parentNode )
    {

        ArrayList<TreeNode>  tnl = new ArrayList<TreeNode>();
        if(input.length() == 0) return tnl;
        else
        {
            Hashtable<String,String> fitsWords = new Hashtable<String, String>();
            for(String word : words)
            {
                if(input.indexOf(word) == 0)//this not be scan
                {
                    String newInput = input.substring(word.length());
                    fitsWords.put(word,newInput);
                }
            }
            for(String w :fitsWords.keySet())
            {
                idCounter ++;
                TreeNode node = new TreeNode(String.valueOf(idCounter), parentNode.getId(),w);
                tnl.add(node);
                tnl.addAll(getNodeList(fitsWords.get(w),words, node)) ;
            }
            return tnl;
        }
    }

}
