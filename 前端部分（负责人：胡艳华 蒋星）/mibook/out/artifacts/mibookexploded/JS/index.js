window.onload = function(){
    var hSlider = function(el,effect){
        var slider = document.getElementById(el),
            picList = slider.getElementsByTagName('ul')[0],
            picListLi = picList.getElementsByTagName('li'),
            pic = picList.getElementsByTagName('img'),
            picLen = pic.length,
            btns = document.getElementById('tabBtns'),
            controlBtns = document.getElementById('controlBtns'),
            imgWidth = picListLi[0].offsetWidth || 2500,
            totalWidth = picLen*imgWidth+'px',
            iNow = i = 0,
            timer = play =  null,
            btnList = '';

        //生成按钮
        for(i=0; i<picLen; i++){
            btnList += '<a href="javascript:;">'+(i+1)+'</a>';
        }
        btns.innerHTML = btnList;
        controlBtns.innerHTML = '<a href="javascript:;" id="prev" class="controlBtn">&lt;</a> <a href="javascript:;" id="next" class="controlBtn">&gt;</a>';

        var btnA = btns.getElementsByTagName('a'),
            btnALen = btnA.length,
            prev = document.getElementById('prev'),
            next = document.getElementById('next');

        //默认给第一个按钮加active
        btnA[0].className = 'active';

        //小于等于1张图的时候，去掉所有按钮
        picLen <= 1 && (btns.innerHTML = controlBtns.innerHTML = '');

        //大于等于2张图的时候，才能自动播放
        picLen >= 2 && autoPlay();

        //计算总宽度
        picList.style.width = totalWidth;

        //根据窗口大小使图片居中
        function toResize(){
            var viewWidth = document.documentElement.clientWidth;
            //屏幕可视区大于1000执行
            if(viewWidth > 1000){
                for(i = 0; i<picLen; i++){
                    pic[i].style.left = -(imgWidth - viewWidth)/2 +'px';
                }
            }
        }
        toResize();
        window.onresize = function(){ toResize(); }

        //底部按钮点击
        for(i=0; i<btnALen; i++){
            btnA[i].index = i;
            btnA[i].onclick = function(){
                iNow = this.index;
                _goto(iNow);
            }
        }

        //上一页
        prev.onclick = function(){
            iNow = getIndex('prev');
            _goto(iNow);
        }

        //下一页
        next.onclick = function(){
            iNow = getIndex('next');
            _goto(iNow);
        }

        //获取索引值
        function getIndex(e){
            switch(e){
                case 'prev':
                    iNow--;
                    if(iNow<0) iNow = picLen-1;
                    break;
                case 'next':
                    iNow++;
                    if(iNow>=picLen) iNow = 0;
                    break;
            }
            return iNow;
        }

        //自动播放
        function autoPlay(){
            play = setInterval(function(){
                iNow = getIndex('next');
                _goto(iNow);
            },2500);
        }

        //鼠标移入 清除定时器
        slider.onmouseenter = function(){
            clearInterval(play);
        }

        //鼠标移出 开启定时器
        slider.onmouseleave = function(){
            autoPlay();
        }

        //轮播切换
        function _goto(i){
            for(i=0; i<picLen; i++){
                if(effect == 'fade'){
                    picListLi[i].style.opacity = 0;
                    picListLi[i].style.filter = "alpha(opacity=0)";
                }
                btnA[i].className = '';
            }
            btnA[iNow].className = 'active';
            if(typeof effect == 'undefined') {effect = 'fade';}
            switch(effect){
                case 'fade':
                    var alpha = 0;
                    clearInterval(timer);
                    timer = setInterval(function(){
                        alpha += 2;
                        alpha > 100 && (alpha = 100);
                        picListLi[iNow].style.opacity = alpha / 100;
                        picListLi[iNow].style.filter = "alpha(opacity = " + alpha + ")";
                        picList.style.left = - (iNow*imgWidth) +'px';
                        alpha == 100 && clearInterval(timer); //解决不断闪烁
                    },20);
                    break;
                case 'left':
                    clearInterval(timer);
                    timer = setInterval(function(){
                        var iTarget = -(iNow * imgWidth);
                        var iSpeed = (iTarget - picList.offsetLeft) / picLen;
                        iSpeed = iSpeed > 0 ? Math.ceil(iSpeed) : Math.floor(iSpeed);
                        picList.offsetLeft == iTarget ? clearInterval(timer) : (picList.style.left = picList.offsetLeft + iSpeed + "px");
                    },20);
                    break;
            }
        }
    }

    //默认调用方法(参数1: 元素id; 参数2: 动画效果,默认值为fade，也可以是left)
    //hSlider('slider'); 或者 hSlider('slider','fade'); //淡入淡出
    hSlider('slider','left'); //左右无缝滚动

}