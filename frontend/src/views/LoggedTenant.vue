<template>
  <div>
    <TenantNavbar />
    <div id="ttcard" class="card pad">

        <div class="column adjust-hero is-centered has-text-centered">
          <HouseMenuEditable>
            <template v-slot:firstEntry>
              <HouseMenuEntry
                imgSource="https://thisrentaldoesnotexist.com/img-new/hero.jpg"
                :args="[
                  {
                    k1: 'house_name',
                    v1: 'House1',
                    k2: 'house_location',
                    v2: 'Location1',
                    k3: 'house_slot',
                    v3: 'Slots: 2/4'
                  },
                ]"
              />
            </template>
            <template v-slot:secondEntry>
              <HouseMenuEntry
                imgSource="https://thisrentaldoesnotexist.com/img-new/hero.jpg"
                :args="[
                  {
                   k1: 'house_name',
                    v1: 'House2',
                    k2: 'house_location',
                    v2: 'Location2',
                    k3: 'house_slot',
                    v3: 'Slots: 1/4'
                  },
                ]"
              />
            </template>
            <template v-slot:thirdEntry>
              <HouseMenuEntry
                imgSource="https://thisrentaldoesnotexist.com/img-new/hero.jpg"
                :args="[
                  {
                    k1: 'house_name',
                    v1: 'House3',
                    k2: 'house_location',
                    v2: 'Location3',
                    k3: 'house_slot',
                    v3: 'Slots: 3/4'
                  },
                ]"
              />
            </template>
            <template v-slot:fourthEntry>
              <HouseMenuEntry
                imgSource="https://thisrentaldoesnotexist.com/img-new/hero.jpg"
                :args="[
                  {
                    k1: 'house_name',
                    v1: 'House4',
                    k2: 'house_location',
                    v2: 'Location1',
                    k3: 'house_slot',
                    v3: 'Slots: 2/4'
                  },
                ]"
              />
            </template>
            <template v-slot:fifthEntry>
              <HouseMenuEntry
                imgSource="https://thisrentaldoesnotexist.com/img-new/hero.jpg"
                :args="[
                  {
                   k1: 'house_name',
                    v1: 'House5',
                    k2: 'house_location',
                    v2: 'Location2',
                    k3: 'house_slot',
                    v3: 'Slots: 1/4'
                  },
                ]"
              />
            </template>
            <template v-slot:sixthEntry>
              <HouseMenuEntry
                imgSource="https://thisrentaldoesnotexist.com/img-new/hero.jpg"
                :args="[
                  {
                    k1: 'house_name',
                    v1: 'House6',
                    k2: 'house_location',
                    v2: 'Location3',
                    k3: 'house_slot',
                    v3: 'Slots: 3/4'
                  },
                ]"
              />
            </template>
            <template v-slot:seventhEntry>
              <HouseMenuEntry
                imgSource="https://thisrentaldoesnotexist.com/img-new/hero.jpg"
                :args="[
                  {
                    k1: 'house_name',
                    v1: 'House7',
                    k2: 'house_location',
                    v2: 'Location3',
                    k3: 'house_slot',
                    v3: 'Slots: 3/4'
                  },
                ]"
              />
            </template>
            <template v-slot:eigthEntry>
              <HouseMenuEntry
                imgSource="https://thisrentaldoesnotexist.com/img-new/hero.jpg"
                :args="[
                  {
                    k1: 'house_name',
                    v1: 'House8',
                    k2: 'house_location',
                    v2: 'Location3',
                    k3: 'house_slot',
                    v3: 'Slots: 3/4'
                  },
                ]"
              />
            </template>
            <template v-slot:ninthEntry>
              <HouseMenuEntry
                imgSource="https://thisrentaldoesnotexist.com/img-new/hero.jpg"
                :args="[
                  {
                    k1: 'house_name',
                    v1: 'House9',
                    k2: 'house_location',
                    v2: 'Location3',
                    k3: 'house_slot',
                    v3: 'Slots: 3/4'
                  },
                ]"
              />
            </template>
          </HouseMenuEditable>
        </div>

        <nav class="pagination" role="navigation" aria-label="pagination">
          <a class="pagination-previous">Previous</a>
          <a class="pagination-next">Next page</a>
        </nav>

    </div>
  </div>
</template>

<script>
import TenantNavbar from "@/components/TenantNavbar";
import HouseMenuEditable from "@/components/HouseMenuEditable.vue";
import HouseMenuEntry from "@/components/HouseMenuEntry.vue"

export default {

  name: "LoggedTenant",
  
  components: {
    TenantNavbar,
    HouseMenuEditable,
    HouseMenuEntry
  },

  methods: {

  },
};
</script>


<style scoped>

label {
  display: block;
}

.pad {
  width: 90%;
  margin: 5% auto;
}

</style>