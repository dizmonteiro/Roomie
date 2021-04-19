<template>
  <div>
    <LandlordNavbar />
        <div id="content">
          <div class="columns is-centered is-vcentered">
            <div class="column is-three-fifths">
              <div class="card" id="loggedlandlordcard">
                <div class="card-image">
                  <carousel >
                    <carousel-slide v-for="slide in slides" :key="slide" class="carousel-slider">
                      <img :src="slide" :alt="slide">
                    </carousel-slide>
                  </carousel>
                </div>
                <div class="card-content">

                  <div class="buttons is-centered">
                    <a class="button is-green vm" href="/">
                       View my Houses
                    </a>
                  </div>

                  <div class="buttons is-centered">
                    <a class="button is-green vm" href="/">
                       Add new Houses
                    </a>
                  </div>

                  <div class="buttons is-centered">
                    <a class="button is-green vm" href="/">
                       Check Applications
                    </a>
                  </div>

                </div>
              </div>
            </div>
          </div>
        </div>
  </div>
</template>

<script>
import LandlordNavbar from '@/components/LandlordNavbar.vue';
import Carousel from '@/components/Carousel.vue';
import CarouselSlide from '@/components/CarouselSlide.vue';

export default {
  data(){
    return {
      slides: [
          'https://picsum.photos/id/164/1080/720',
          'https://picsum.photos/id/163/1080/720',
          'https://picsum.photos/id/308/1080/720',
          'https://picsum.photos/id/322/1080/720',
          'https://picsum.photos/id/351/1080/720',
          'https://picsum.photos/id/369/1080/720',
          'https://picsum.photos/id/398/1080/720'
      ]
    }
  },

  name: 'LoggedLandlord',

  components: {
    LandlordNavbar,
    Carousel: Carousel,
    CarouselSlide: CarouselSlide
  }
}
</script>

<style>

  #content {
    margin: 3% auto;
    width: 100%;
  }

  #preview {
    min-height: 200px;
    max-height: 200px;
  }

  #filler {
    min-height: 90vh;
  }

  @media (max-width: 770px) {
    #loggedlandlordcard{
        margin: 3% auto;
        min-height: 80vh;
    }
  }

  label { display:block }

  .vm {
    width: 25%;
    min-width: 70px;
  }

  .carousel {
    position:relative;
    overflow: hidden;
    max-width:100%;
    height:400px;
    z-index:10;
  }

  img {
    object-fit: contain;
  }
  
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

  .carousel-slider {
    position:absolute;
    top:10;
    left:0;
    bottom:0;
    right:0;
  }
  
  .carousel-slider img {
    width:100%;
    height:100%;
  }
</style>