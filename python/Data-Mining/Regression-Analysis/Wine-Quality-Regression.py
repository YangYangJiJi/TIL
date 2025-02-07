import pandas as pd
red_df = pd.read_csv('./winequality-red.csv', sep = ';', header = 0, engine = 'python')
white_df = pd.read_csv('./winequality-white.csv', sep = ';', header = 0, engine= 'python')
red_df.to_csv('./winequality-red2.csv', index = False)
white_df.to_csv('./winequality-white2.csv', index = False)

red_df.insert(0, column = 'type', value = 'red')
white_df.insert(0, column = 'type', value = 'white')
wine = pd.concat([red_df, white_df])
#wine.to_csv('wine.csv', index = False)
wine.columns = wine.columns.str.replace(' ', '_')

from scipy import stats #t검정시작
from statsmodels.formula.api import ols, glm

red_wine_quality = wine.loc[wine['type'] == 'red', 'quality']
white_wine_quality = wine.loc[wine['type'] == 'white', 'quality']
stats.ttest_ind(red_wine_quality, white_wine_quality, equal_var = False)

Rformula = 'quality ~ fixed_acidity + volatile_acidity + citric_acid + residual_sugar + chlorides + free_sulfur_dioxide + total_sulfur_dioxide + density + pH + sulphates + alcohol'
regression_result = ols(Rformula, data = wine).fit()
regression_result.summary()

sample1 = wine[wine.columns.difference(['quality', 'type'])]
sample1 = sample1[0:5][:]
sample1_predict = regression_result.predict(sample1)
sample1_predict

data = {"fixed_acidity" : [8.5, 8.1], "volatile_acidity":[0.8, 0.5], "citric_acid":[0.3, 0.4], "residual_sugar":[6.1, 5.8], "chlorides":[0.055,0.04], "free_sulfur_dioxide":[30.0, 31.0], "total_sulfur_dioxide":[98.0,99], "density":[0.996, 0.91], "pH":[3.25, 3.01], "sulphates":[0.4, 0.35], "alcohol":[9.0, 0.88]}
sample2 = pd.DataFrame(data, columns= sample1.columns)
sample2

import matplotlib.pyplot as plt #히스토그램
import seaborn as sns
sns.set_style('dark')
sns.distplot(red_wine_quality, kde = False, color = "red", label = 'red wine')
sns.distplot(white_wine_quality, kde = False, label = 'white wine')
plt.title("Quality of Wine Type")
plt.legend()
plt.show()

import statsmodels.api as sm #부분회귀
others = list(set(wine.columns).difference(set(["quality", "fixed_acidity"])))
p, resids = sm.graphics.plot_partregress("quality", "fixed_acidity", others, data = wine, ret_coords = True)
plt.show()
fig = plt.figure(figsize = (8, 13))
sm.graphics.plot_partregress_grid(regression_result, fig = fig)
plt.show()
#그림의 형태가 8x13으로 나옴.