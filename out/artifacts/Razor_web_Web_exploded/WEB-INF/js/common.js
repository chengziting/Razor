/**
 * Created by user on 2017-07-28.
 */

function login(name,pwd,verifyCode,callBack) {
    var vm = {
        "name":name,
        "password":pwd,
        "verifyCode":verifyCode
    };
    $.ajax({
        type:"post",
        contentType:"application/ajax;charset=utf-8",
        dataType:"json",
        url:"/account/api/getLoginResultAjax.htm",
        data:JSON.stringify(vm),
        success:function(data){
            callBack(true,data);
        },
        error:function(er){
            callBack(false,er);
        }
    });
}
