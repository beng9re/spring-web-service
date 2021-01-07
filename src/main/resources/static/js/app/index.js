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
        const sucessss = () => {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }
        
        try{
            const postResponse = await fetch('/api/v1/posts',{
                method : 'post',
                headers : {
                    'Content-Type' : 'application/json;charset=utf-8',
                },
                body: JSON.stringify(data)
            });
            const jsonData = await postResponse.json();
            await sucessss();
        }catch(err){
            alert(JSON.stringify(err));
        }
        



        
        // fetch('/api/v1/posts',{
        //     method : 'post',
        //     headers : {
        //         'Content-Type' : 'application/json;charset=utf-8',
        //     },
        //     body: JSON.stringify(data)
        // }).then(function(res){
        //     return res.json();
        // }).then(function(data){
        //     alert('글이 등록되었습니다.');
        //     window.location.href = '/';
        // }).catch(function(err){
   
        // });
            
        

    }
};

main.init();
