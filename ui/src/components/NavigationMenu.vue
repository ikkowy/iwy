<template>
  <v-card variant="text">
    <v-list>
      <v-list-item
        v-for="entry in props.links"
        :key="entry.title"
        class="py-5"
        :disabled="entry.disabled"
        :href="entry.href"
        variant="text"
      >
        <template #prepend>
          <v-icon :icon="entry.icon" style="opacity: 1" />
        </template>
        <v-list-item-title>{{ entry.title }}</v-list-item-title>
      </v-list-item>
    </v-list>
  </v-card>
</template>

<script setup lang="ts">
interface Link {
  disabled?: boolean,
  href: string
  title: string,
  icon: string
}

interface Props {
  links: Link[];
}

const props = defineProps<Props>();
</script>
