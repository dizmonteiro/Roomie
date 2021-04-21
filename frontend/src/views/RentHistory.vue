<template>
  <div>
    <tenant-navbar />
    <div class="columns">
      <div class="column is-full has-text-centered">
    <h1 class="title  is-1">My Rent History</h1>
      </div>

    </div>
    <div id="scroll-area">
      <smooth-scrollbar>
        <rent-history-entry
          :houseSlides="house1Slides"
          :houseLocation="'Braga'"
          :houseName="'T3 com Piscina'"
          :tenants="tenantsHouse1"
          :from="'01/01/2020'"
          :to="'23/08/2020'"
          :landlord="landlordHouse1"
        />
        <rent-history-entry
          :houseSlides="house1Slides"
          :houseLocation="'Braga'"
          :houseName="'T3 com Piscina'"
          :tenants="tenantsHouse1"
          :from="'01/01/2020'"
          :to="'23/08/2020'"
          :landlord="landlordHouse1"
        />
        <rent-history-entry
          :houseSlides="house1Slides"
          :houseLocation="'Braga'"
          :houseName="'T3 com Piscina'"
          :tenants="tenantsHouse1"
          :from="'01/01/2020'"
          :to="'23/08/2020'"
          :landlord="landlordHouse1"
        />
        <rent-history-entry
          :houseSlides="house1Slides"
          :houseLocation="'Braga'"
          :houseName="'T3 com Piscina'"
          :tenants="tenantsHouse1"
          :from="'01/01/2020'"
          :to="'23/08/2020'"
          :landlord="landlordHouse1"
        />
      </smooth-scrollbar>
    </div>
  </div>
</template>

<script>
import RentHistoryEntry from "../components/RentHistoryEntry.vue";
import TenantNavbar from "../components/TenantNavbar.vue";

export default {
  components: { TenantNavbar, RentHistoryEntry },
  data() {
    return {
      wh:window.innerHeight,
      landlordHouse1: {
        photo: "https://randomuser.me/api/portraits/men/54.jpg",
        name: "Hugo Manuel",
      },
      tenantsHouse1: [
        {
          name: "jose filipe",
          photo: "https://randomuser.me/api/portraits/men/52.jpg",
        },
        {
          name: "antonio ramalho",
          photo: "https://randomuser.me/api/portraits/men/51.jpg",
        },
        {
          name: "antonio ramalho",
          photo: "https://randomuser.me/api/portraits/men/51.jpg",
        },
        {
          name: "marco antunes",
          photo: "https://randomuser.me/api/portraits/men/53.jpg",
        },
      ],
      house1Slides: [
        "https://picsum.photos/id/164/1080/720",
        "https://picsum.photos/id/163/1080/720",
        "https://picsum.photos/id/308/1080/720",
        "https://picsum.photos/id/322/1080/720",
        "https://picsum.photos/id/351/1080/720",
        "https://picsum.photos/id/369/1080/720",
        "https://picsum.photos/id/398/1080/720",
      ],
    };
  },
  computed: {
    userStyle () {
      return {
        '--scroll-height': window.innerHeight
      }
    }
  }
};
</script>

<style scoped>
.title{
  margin: 3% auto 0 auto;
}
.sCard {
  margin: 1% auto;
}
 #scroll-area {
   margin: 2% auto;
    width: 100%;
    height: 650px;
  }
</style>