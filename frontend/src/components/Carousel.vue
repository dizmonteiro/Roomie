<template>
    <div class="carousel"  @keydown="checkSlide($event)" tabindex="0">
        <slot></slot>
        <button @click.prevent="next" class="btn btn-next"><i class="fa fa-angle-right"></i></button>
        <button @click.prevent="prev" class="btn btn-prev"><i class="fa fa-angle-left"></i></button>
    </div>
</template>

<script>
export default {

    data () {
        return {
            index : 0,
            slides : [],
            slideDirection: '',
        }
    },

    computed: {
        slidesLength() {
            return this.slides.length;
        }
    },

    mounted(){
        this.slides = this.$children;
        this.slides.map( (slide,index) => {
            slide.index = index;
        });
    },

    methods: {

        next(){
            this.index++;
            if(this.index >= this.slidesLength){
                this.index = 0;
            }
            this.slideDirection = 'slide-right';
        },

        prev(){
            this.index--;
            if(this.index < 0){
                this.index = this.slidesLength - 1;
            }
             this.slideDirection = 'slide-left';
        },

        checkSlide(event){
            if(event.keyCode === 39){
                this.next();
            }else if (event.keyCode === 37){
                this.prev();
            }else {
                return;
            }
        }
    }
}
</script>

<style scoped>

  .btn {
    padding:5px 10px;
    background-color:rgba(0,0,0,0);
    border:1px solid transparent;
    margin:5px 10px;
    color:#FFF;
    height:380px;
    width:100px;
    position:absolute;
    margin-top:-190px;
    z-index:2;
  }

  .btn:hover {
    cursor: pointer;
  }
    
  .btn:focus{
    outline:none;
  }
  
  .btn-next {
    top:50%;
    right:0;
  }
  
  .btn-prev {
    top:50%;
    left:0;
  }

</style>