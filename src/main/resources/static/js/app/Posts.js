class Posts{
    constructor() {
        this.eventMapper();
    }

    eventMapper(){
        const _this = this;
        $('#btn-save').on('click',function() {
        
            _this.save();
        });
    }

    save(){
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
            }
            const jsonData = await postResponse.json();
            console.info(jsonData);
            alert('글이 등록되었습니다.');
            window.location.href = '/';
            return jsonData;
            }
        postData().catch(err=>{alert(err)});
    }
}

export default new Posts();


