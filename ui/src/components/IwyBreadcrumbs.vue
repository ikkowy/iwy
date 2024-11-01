<template>
  <v-breadcrumbs density="compact" :items="props.breadcrumbs">
    <template v-slot:prepend>
      <v-btn icon="mdi-home" href="/" density="compact" variant="flat" class="mr-1" />
      <v-icon icon="mdi-chevron-right" />
    </template>
    <template v-slot:divider>
      <v-icon icon="mdi-chevron-right" />
    </template>
  </v-breadcrumbs>
  <v-divider />
</template>

<script setup lang="ts">
interface Breadcrumb {
  title: string,
  disabled?: boolean,
  href: string
}

interface Props {
  breadcrumbs: Breadcrumb[];
}

const props = defineProps<Props>();
</script>
