<template>
  <div>
    <DefaultNavbar />
        <div id="content">
          <div class="columns is-centered is-vcentered">
            <div class="column is-three-fifths">
              <div class="card" id="homecard">

                <div class="card-image">
                  <carousel >
                    <carousel-slide v-for="slide in slides" :key="slide" class="carousel-slider">
                      <img :src=slide :alt="slide">
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
                    <a class="button is-green" href="/register">
                      <strong>Register</strong>
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
import DefaultNavbar from '@/components/DefaultNavbar';
import Carousel from '@/components/Carousel.vue';
import CarouselSlide from '@/components/CarouselSlide.vue';

export default {
  data(){
    return {
      slides: [
          'background1.jpeg',
          'background2.jpeg',
          'background3.jpeg'
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

<style scoped>

  #content {
    margin: 3% auto;
    width: 100%;
  }

  @media (max-width: 770px) {
    #homecard{
        margin: 3% auto;
        min-height: 80vh;
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