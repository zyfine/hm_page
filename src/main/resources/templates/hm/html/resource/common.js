;
$("#page").paging({
    pageNum: currpage, // 当前页面
    totalNum: totalNum, // 总页码
    totalList: total, // 记录总数量
    callback: function (num) { //回调函数
        if(num==1){
            window.location.href = "index.html";
        }else{
            window.location.href = "index"+num+".html";
        }
    }
});

function searchText (array,type,value) {
    if(!Array.isArray(array)) throw new Error('第一个参数必须是数组类型');
    var arr=[];
    arr=array.filter(function(a) {
        return a[type].toString().indexOf(value)!=-1;
    });
    return arr;
};
function readTextFile(file, callback) {
    var rawFile = new XMLHttpRequest();
    rawFile.overrideMimeType("application/json");
    rawFile.open("GET", file, true);
    rawFile.onreadystatechange = function() {
        if (rawFile.readyState === 4 && rawFile.status == "200") {
            callback(rawFile.responseText);
        }
    }
    rawFile.send(null);
}
function ajaxSubmit(){
    var title = $("#title").val();
    readTextFile("resource/book.json", function(text){
        var data = JSON.parse(text);
        var s = searchText(data,'title',title);
        searchResult(s);
    });
}
function searchResult(s) {
    $(".trcc").remove();
    $("#page").remove();
    $.each(s,function(index,value){
        var bookid = value.id;
        var title = value.title;
        var title_pic = value.title_pic;
        var latest_time = value.latest_time;
        $("#allbook").append("<tr  class=\"trcc\"><td><a href='"+bookid+"/index.html'>"+title+"</a></td><td><img src="+title_pic+" /></td><td>"+latest_time+"</td></tr>");
    });
}