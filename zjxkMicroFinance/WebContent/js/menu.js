$(document).ready(function() {
	/*1st example*/
	/// wrap inner content of each anchor with first layer and append background layer
	$("#menu li a").wrapInner( '<span class="out"></span>' ).append( '<span class="bg"></span>' );
	// loop each anchor and add copy of text content
	$("#menu li a").each(function() {
		$( '<span class="over">' +  $(this).text() + '</span>' ).appendTo( this );
		});
		$("#menu li a").hover(function() {
			// this function is fired when the mouse is moved over
			$(".out",	this).stop().animate({'top':'46px'}, 250); // move down - hide
			$(".over",	this).stop().animate({'top':'0px'},	250); // move down - show
			$(".bg",	this).stop().animate({'top':'0px'},	120); // move down - show
		},function() {
			// this function is fired when the mouse is moved off
			$(".out",	this).stop().animate({'top':'0px'},	250); // move up - show
			$(".over",	this).stop().animate({'top':'-46px'}, 250); // move up - hide
			$(".bg",	this).stop().animate({'top':'-46px'}, 120); // move up - hide
		});
					
    /*2nd example*/
	$("#menu2 li a").wrapInner( '<span class="out"></span>' );
	$("#menu2 li a").each(function() {
		$( '<span class="over">' +  $(this).text() + '</span>' ).appendTo( this );
		});
		$("#menu2 li a").hover(function() {
			$(".out",	this).stop().animate({'top':'46px'}, 200); // move down - hide
			$(".over",	this).stop().animate({'top':'0px'},	200); // move down - show
		}, function() {
			$(".out",	this).stop().animate({'top':'0px'},	200); // move up - show
			$(".over",	this).stop().animate({'top':'-46px'}, 200); // move up - hide
		});
});


//变换表格

function switch_tab_two(d,num,menu,obj)
{

   var index=parseInt(d);   
	   for(var ti=0;ti<num;ti++)
   {
		if(index==ti){
           document.getElementById(obj+ti).style.display = "block";
           document.getElementById(menu).className = "currentarea"+ti;   //让标签显示为"当前样式"   
		         
       }else{
           document.getElementById(obj+ti).style.display = "none";
           //document.getElementById(menu+ti).className = "currentarea"+ti;   //这里让其它标签显示为"非当前样式"
       }
	}   
}
var isPollTwo = true;
var pollVarTwo =0;   //产生随机默认标签序号


function setPollTwo(v)       //用true和false控制自动轮换
{
isPollTwo=v;
}

function pollPlayTwo()
{
if (isPollTwo)
{
   pollVarTwo=pollVarTwo%2; 
   switch_tab_two(pollVarTwo,2,'arealabel','numpanel');
   pollVarTwo++;
}
}

//查看联系方式
function showContact(selectValue,num)
{
	for(i=1;i<=num;i++)
	{
		if(selectValue==i)
		{
			document.getElementById("city"+i).style.display="block";		
		}
		else
		{
			document.getElementById("city"+i).style.display="none";	
		}
	}
}