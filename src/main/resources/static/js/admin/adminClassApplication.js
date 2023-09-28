//수정 버튼
$('.approval-btn').on('click',function (){
    let classNumber = $(this).data('number');
    // AJAX 요청으로 데이터 수정
    $.ajax({
        type: 'get',
        url: '/admin/approvalClass?classNumber=' + classNumber,
        success: function () {
            alert('성공적으로 승인했습니다.');
            location.reload();
        },
        error: function (a,b,c) {
            console.error(c);
        }
    });
});
// 거부 refusal-btn
$('.refusal-btn').on('click',function (){
    let classNumber = $(this).data('number');
    // AJAX 요청으로 데이터 수정
    $.ajax({
        type: 'get',
        url: '/admin/refusalClass?classNumber=' + classNumber,
        success: function () {
            alert('성공적으로 거절했습니다.');
            location.replace('/admin/classPlan');
        },
        error: function (a,b,c) {
            console.error(c);
        }
    });
});
$('.remove-btn').on('click',function (){
    let classNumber = $(this).data('number');
    // AJAX 요청으로 데이터 수정
    $.ajax({
        type: 'get',
        url: '/admin/removeClass?classNumber=' + classNumber,
        success: function () {
            alert('성공적으로 거절했습니다.');
            location.reload();
        },
        error: function (a,b,c) {
            console.error(c);
        }
    });
});
