<template>
  <div>
    <LandlordNavbar />
    <div class="columns is-centered is-vcentered is-mobile is-tablet is-desktop is-multiline">
      <div class="column is-four-fifths-mobile is-four-fifths-tablet is-three-quarters-desktop">
        <div id="checkhouse-card">

          <div class="card-image">
            <carousel >
              <carousel-slide v-for="slide in slides" :key="slide" class="carousel-slider">
                <img :src="slide" :alt="slide">
              </carousel-slide>
            </carousel>
          </div>

          <div class="columns is-centered is-vcentered is-mobile is-tablet is-desktop">
            <div class="column is-4-mobile is-4-tablet is-4-desktop">
              <div class="box">
                <p class="title has-text-centered is-3">Main Info</p>
                <p class="subtitle">This column has house info</p>
              </div>
            </div>
            <div class="column is-4-mobile is-4-tablet is-4-desktop">
              <div class="box">
                <p class="title has-text-centered is-3">Description</p>
                <p class="subtitle">This column has house description</p>
              </div>
            </div>
            <div class="column is-4-mobile is-4-tablet is-4-desktop">
              <div class="box">
                <p class="title has-text-centered is-3">Members</p>
                <p class="subtitle">This column has house members</p>
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

<style scoped>

  #content {
    margin: 3% auto 2% auto;
    width: 100%;
  } 
  
  #checkhouse-card {
      min-height: 80vh;
      margin-top: 2%;
      margin-bottom: 5%;
  }

  #scroll-area-1 {
      height: 34vh;
  }

  #scroll-area-2 {
      height: 58vh;
      margin-bottom: 10px;
  }
  
  .price-range {
      display: flex;
      flex-direction: row;
      justify-content: space-between;
  }

  .spacer {
      width: 5px;
  }

  .vm {
    width: 25%;
    min-width: 70px;
  }

  .carousel {
    position:relative;
    overflow: hidden;
    max-width:100%;
    height:46vh;
    z-index:10;
  }

  img {
    object-fit: contain;
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

  .bordera {
  background-color: lightseagreen;
  }
  
  .borderb {
  background-color: pink;
  }

  .borderc {
  background-color: orange;
  }

</style>