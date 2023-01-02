/* 
  JavaScipt function demo
  October  25 2022
  yifan
*/


document.addEventListener("DOMContentLoaded",load);

// Path: module6 Javascript/ninja.js  
function load() {
    let container = document.getElementById("main_container");
    //setAttributes is a function defined in module6 Javascript/ninja.js  
    container.setAttribute("class","container");

    //获取p标签 
    let paragraph = document.getElementsByTagName("p");
    //使用loop 遍历所有的p标签  
    for(let i = 0;i < paragraph.length;i++){ 
    paragraph[i].setAttribute("style","background-color:#FFF"); //设置p标签的背景颜色 
    }

 
    // 获取table标签
    let table = document.getElementsByTagName("table");
    // loop through all the table tags  遍历所有的table标签
    for(let i = 0;i < table.length;i++){

      //获取table标签的所有tr标签
      let trs = table[i].getElementsByTagName("tr");
      //loop through all the tr tags  遍历所有的tr标签
      for(let j = 0;j < trs.length;j++){
          //  % 2 == 0 代表偶数 
          if(j % 2 == 0){
          //设置tr标签的背景颜色
          trs[j].setAttribute("class","zebra");
          }
       }
}

}