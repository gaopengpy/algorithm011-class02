本周主要学习了位运算、布隆过滤器和LRU缓存以及排序算法

1.冒泡排序

function bubbleSort(arr){
  int len = arr.length();
  for(int i=0; i<len; i++){
	  for(int j=0; j<len; j++){
		 if(arr[j]>arr[j+1]){
		    int temp = arr[j+1];
		    arr[j+1] = arr[j]; 
		    arr[j] = temp;
		 }				
	  }  
  }
  
  return arr;
}

2.选择排序

function selectionSort(arr){
  int len = arr.length();
  for(int i=0; i<len; i++){
      minIndex = i;
	  for(int j=i+1; j<len; j++){
		if(arr[j] < arr[minIndex]){
			minIndex = j;
		}
	  }  
	  
	 int temp = arr[i];
	 arr[j] = arr[j]; 
	 arr[i] = temp;	  
  }
  
  return arr;  
}