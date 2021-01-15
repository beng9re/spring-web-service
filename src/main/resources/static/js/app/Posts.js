class Posts{
    constructor() {
        this.eventMapper();
    }

    eventMapper(){
        const _this = this;
        $('#btn-save').on('click',function() {
            _this.save();
        });

        $('#btn-update').on('click',function(){
            _this.update();
        });

       $('#btn-delete').on('click',function(){
                _this.delete();
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
    update(){
        const data = {
            title: $('#title').val(),
            content:$('#content').val()
        };

        const id = $('#id').val();

        const updateData = async () => {
            const response = await fetch(`/api/v1/posts/${id}`,{
                method:'put',
                headers:{
                    'Content-Type': 'application/json;charset=utf-8',
                },
                body:JSON.stringify(data)
            });
            const jsonData = await response.json();
            if(!response.ok){
                throw new Error("서버에러");
            }
            alert('글이 수정 되었습니다.')
            window.location.href = '/';
            return jsonData;
        }
        updateData().catch(err => {alert(err)});
    }

    delete(){
        const id = $('#id').val();
        const deleteData = async () =>{
            const response = await fetch(`/api/v1/posts/${id}`,{
                method:'delete',
                headers:{
                    'Content-Type': 'application/json;charset=utf-8',
                }
            });

            const jsonData = await response.json();
            if(!response.ok){
                throw new Error("서버에러");
            }
            alert('글이 삭제 되었습니다.')
            window.location.href = '/';
            return jsonData; 
        }
        deleteData().catch(err => {alert(err)});
    }

}

export default new Posts();


