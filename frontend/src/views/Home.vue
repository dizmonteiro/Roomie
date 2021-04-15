<template>
  <div>
    <DefaultNavbar />
    <section class="hero is-fullheight-with-navbar">
      <div class="hero-body">
        <div id="content">
          <div class="columns is-centered is-vcentered">
            <div class="column is-three-fifths">
              <div class="card" id="homecard">
                <div class="card-image">
                  <carousel >
                    <carousel-slide v-for="slide in slides" :key="slide" class="carousel-slider">
                      <img :src="slide" :alt="slide">
                    </carousel-slide>
                  </carousel>
                </div>
                <div class="card-content">
                  <div class="content has-text-justified">
                    <p>
                      A Roomie é uma Plataforma de Procura e Disponibilização de Imobiliário para Arrendamento que procura não só facilitar o processo de encontrar uma habitação como também o processo da escolha do ambiente em que se pretende viver.
                    </p>
                  </div>
                    
                  <div class="buttons is-centered">
                    <a class="button is-light" href="/login">
                       Login
                    </a>
                    <a class="button is-primary" href="/register">
                      <strong>Register</strong>
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import DefaultNavbar from '@/components/DefaultNavbar';
import Carousel from '@/components/Carousel.vue';
import CarouselSlide from '@/components/CarouselSlide.vue';

export default {
  data(){
    return {
      slides: [
          'https://picsum.photos/id/164/703/400',
          'https://picsum.photos/id/163/703/400',
          'https://picsum.photos/id/308/703/400',
          'https://picsum.photos/id/322/703/400',
          'https://picsum.photos/id/351/703/400',
          'https://picsum.photos/id/369/703/400',
          'https://picsum.photos/id/398/703/400'
      ]
    }
  },

  name: 'Home',

  components: {
    DefaultNavbar,
    Carousel: Carousel,
    CarouselSlide: CarouselSlide
  }
}
</script>

<style>
  #content {
    width: 100%;
  }

  .home {
    margin: 0px 50px;
  }

  @media (max-width: 770px) {
    #homecard{
      margin: 20px 50px 0px 50px;
    }
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
    width:50px;
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