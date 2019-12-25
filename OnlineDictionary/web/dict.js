/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// var makeRequest=(function(){
//    let d =$("#word").val();
//    $.ajax({
//        type:"POST",
//        url :"DictSevlet",
//        data:{"Requestd":d},
//        success: function(data){
//            
//            $("#result").html(data);
//        },
//        error: function(e){
//            $("#result").html(e.textResponse);
//        }   
//    })();
//});
//$(document).ready(function(){
//    $("#btn").click(function(){
//        
//        makeRequest();
//    });
//});
($(document).ready(function () {
    var makeRequest = (function () {
        var _search = function () {
                    let d = $("#word").val();

            $.ajax({
                type: "POST",
                url: "DictSevlet",
                data: {"Requestd": d},
                success: function (data2) {

                    $("#result").html(data2);
                },
                error: function (e) {
                    $("#result").html(e.textResponse);
                }
            });
        };
        var getResults = function () {
            $("#btn").click(function () {
                _search();
            });
        };
        return{
            results: getResults
        };
    })();
    makeRequest.results();
}))();


