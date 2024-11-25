<template>
  <v-breadcrumbs density="compact" :items="props.breadcrumbs">
    <template #prepend>
      <v-btn
        class="mr-1"
        density="compact"
        href="/"
        icon="mdi-home"
        variant="flat"
      />
      <v-icon v-if="props.breadcrumbs?.length > 0" icon="mdi-chevron-right" />
    </template>
    <template #divider>
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
