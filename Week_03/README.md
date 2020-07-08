本周学习了递归算法。

写递归最重要的是有终止条件，否则就会无限循环，代码模板如下：

// Java
public void recur(int level, int param) { 
  // 递归的终止条件
  if (level > MAX_LEVEL) { 
  
    return; 
  }
  
  // 处理当前层逻辑
  process(level, param); 
  
　// 下探到下一层
  recur( level: level + 1, newParam); 
  

  // 清理当前层
 
}

分治和回溯是递归的高级应用形式。


LinkedList result = new LinkedList();
public void backtrack(路径，选择列表){
    if(满足结束条件){
        result.add(结果);
    }
    for(选择：选择列表){
        做出选择;
        backtrack(路径，选择列表);
        撤销选择;
    }
}
