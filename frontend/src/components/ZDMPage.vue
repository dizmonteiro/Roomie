<template>
    <li>
        <a :class="['pagination-link', { 'is-current': current === page }]"
            @click="onChange(page)">
            {{ page }}
        </a>
    </li>
</template>

<script>
export default {

  name: 'ZDMPage',

  props: ['page', 'current', 'onChange']

}
</script>