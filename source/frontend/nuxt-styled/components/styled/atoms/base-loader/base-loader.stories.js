import BaseLoader from "./base-loader.vue";

export default {
  title: 'Styled/Atoms/[PCFC] 로더',
  components: BaseLoader,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 20px; font-size: 20px; color: #212121;">(예시) Loader Element </h2><div style="display: flex; flex-direction: row; "><story /></div></div>',
    }),
  ],
};

export const Default = () => ({
  components: { BaseLoader },
  template:
    `
      <div class="v-group v-group--gap-12">
        <BaseLoader class="loader--lg"></BaseLoader>
        <BaseLoader></BaseLoader>
        <BaseLoader class="loader--sm"></BaseLoader>
      </div>
    `
});
