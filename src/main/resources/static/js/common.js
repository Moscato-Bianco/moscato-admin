/**
 * ajax call
 * @param url
 * @param param
 * @param reqtype
 * @param dataType
 * @returns
 */
function callService(url, param, reqtype, dataType, isNoShowLoad){

    if(reqtype == undefined){
        reqtype = 'post';
    }

    if(dataType == undefined){
        dataType = 'json';
    }

    if(isNoShowLoad == undefined){
        isNoShowLoad = false;
    }

   return $.ajax({
        type: reqtype,
        dataType :dataType,
        data : param,
        url: url,
        beforeSend : function(xhr){
            xhr.setRequestHeader("req_type", "ajax");
        },
        error   : function (msg) {
            Toastify({
                text: '잠시후 다시 시도해주세요.<br>재시도 이후에도 문제가 발생한다면<br>더보기 > 문의하기 메뉴로 접수해주세요.',
                className: "error",
                duration: 3000,
            }).showToast();
        },
        success: function(data){
            return $.when(data);
        }
    });

}