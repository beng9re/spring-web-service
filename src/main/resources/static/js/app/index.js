var main = {
    init : function(){
        var _this = this;
        $('#btn-save').on('click',function(){
            _this.save();
        });
    },
    save : async function () {
        const data = {
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val()
        };
        const postData = async () => {
            const postResponse = await fetch('/api/v1/posts', {
                method: 'post',
                headers: {
                    'Content-Type': 'application/json;charset=utf-8',
                },
                body: JSON.stringify(data)
            });

            if(!postResponse.ok){
                throw new Error("서버에러");
                return;
            }
            const jsonData = await postResponse.json();
            console.info(jsonData);
            alert('글이 등록되었습니다.');
            window.location.href = '/';
            return;
         }
         postData().catch(err=>{alert(err)});

    }
};

main.init();
